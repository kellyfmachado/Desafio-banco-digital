
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato - Conta Poupanca ===");
		super.imprimirInfosComuns();
		for (String Transacoes: extrato){
			System.out.println(Transacoes);
		}
		System.out.println("================================");
	}

	@Override
	public void exibirSaldo() {
		System.out.println("=== Saldo - Conta Poupanca ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("Saldo: %.2f", this.saldo));	
		System.out.println("================================");
	}

}