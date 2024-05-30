import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		//Selecionadno banco
		Banco banco = new Banco();
		banco.setNome("Santander");

		//Cadastrando cliente
		Cliente cliente = new Cliente("777.777.777-77");
		cliente.setNome("Kelly");

		//Criando conta poupança e conta corrente, para o mesmo cliente
		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

		// Criando uma lista de contas
        List<Conta> listaDeContas = new ArrayList<>();
        listaDeContas.add(cc);
        listaDeContas.add(poupanca);

		banco.setContas(listaDeContas);
		
		//Exibindo informações do banco, seguido da lista de contas desse banco
		banco.exibirInfoBanco();
		banco.exibirListaContas();

		//Realizando transações
		cc.depositar(1000);
		cc.transferir(100, poupanca);
		cc.transferir(600, poupanca);
		poupanca.transferir(400, cc);

		try {
			poupanca.sacar(400);;
		} catch (SemSaldoException e) {
			System.out.println("================================");
			System.out.println(e.getMessage());
			System.out.println("================================");
		}
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		cc.exibirSaldo();
		poupanca.exibirSaldo();
	}

}