import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	//Ddaos da conta
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<String> extrato;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.extrato = new ArrayList<>();
	}

	//Método de saque
	@Override
	public void sacar(double valor) throws SemSaldoException {
		if (saldo<valor)
			throw new SemSaldoException("Saldo insuficiente!");
		saldo -= valor;
		extrato.add(String.format("Saque de: %.2f", valor));
	}

	//Método de depósito
	@Override
	public void depositar(double valor) {
		saldo += valor;
		extrato.add(String.format("Deposito de: %.2f", valor));
	}

	//Método de transferência
	@Override
	public void transferir(double valor, Conta contaDestino) {
		try {
			this.sacar(valor);
			contaDestino.depositar(valor);
			extrato.add(String.format("Transferencia no valor de %.2f da conta %d para a conta %d", valor, this.numero, contaDestino.getNumero()));
		} catch (SemSaldoException e) {
			System.out.println("================================");
			System.out.println(e.getMessage());
			System.out.println("================================");
		}

	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	//Informações communs a todas as contas
	protected void imprimirInfosComuns() {
		System.out.println("================================");
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
	}
}