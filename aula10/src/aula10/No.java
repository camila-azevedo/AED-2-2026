package aula10;

public class No {
	// propriedades
	private int numero = 0;
	private No esquerda = null;
	private No direita = null;
	
	// métodos construtores
	public No() {
		super();
	}
	public No(int numero, No esquerda, No direita) {
		super();
		this.numero = numero;
		this.esquerda = esquerda;
		this.direita = direita;
	}
	
	// métodos de acesso
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public No getEsquerda() {
		return esquerda;
	}
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	public No getDireita() {
		return direita;
	}
	public void setDireita(No direita) {
		this.direita = direita;
	} 
	
	
	
	
}
