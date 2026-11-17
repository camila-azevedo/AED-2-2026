package aula14;

public class RetornoRecursao {
	// propriedades da classe
	private int chaveDoMeio = 0;
	private No filhoDoMeio = null;
	
	// métodos construtores
	public RetornoRecursao() {
		super();
	}
	public RetornoRecursao(int chaveDoMeio, No filhoDoMeio) {
		super();
		this.chaveDoMeio = chaveDoMeio;
		this.filhoDoMeio = filhoDoMeio;
	}
	
	// métodos de acesso
	public int getChaveDoMeio() {
		return chaveDoMeio;
	}
	public void setChaveDoMeio(int chaveDoMeio) {
		this.chaveDoMeio = chaveDoMeio;
	}
	public No getFilhoDoMeio() {
		return filhoDoMeio;
	}
	public void setFilhoDoMeio(No filhoDoMeio) {
		this.filhoDoMeio = filhoDoMeio;
	}
	
	
	
}
