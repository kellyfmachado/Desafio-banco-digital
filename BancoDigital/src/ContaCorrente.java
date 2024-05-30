
public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		for (String Transacoes: extrato){
			System.out.println(Transacoes);
		}
		System.out.println("================================");
	}

	@Override
	public void exibirSaldo() {
		System.out.println("=== Saldo - Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Saldo: %.2f", this.saldo));	
		System.out.println("================================");
	}
	
}