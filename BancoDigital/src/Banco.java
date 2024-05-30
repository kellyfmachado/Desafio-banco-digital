import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void exibirInfoBanco  (){
		System.out.println("================================");
		System.out.println(String.format("Nome do banco: %s", nome));
		System.out.println("================================");
	}

	public void exibirListaContas () {
		System.out.println("================================");
        for (Conta conta : contas) {
            System.out.println("Conta: " + conta.getNumero());
        }
		System.out.println("================================");
	}

}