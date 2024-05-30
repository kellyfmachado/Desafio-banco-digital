
public interface IConta {
	
	void sacar(double valor) throws SemSaldoException;
	
	void depositar(double valor);
	
	void transferir(double valor, Conta contaDestino) throws SemSaldoException;
	
	void exibirSaldo();

	void imprimirExtrato();
}