package aula14;

public class No {
	// propriedads
	private int[] chaves = null;
	private No[] filhos = null;
	private boolean folha = true;
	private int qtdChaves = 0;
	
	// método construtor cheio da classe
	public No(int tamanho) {
		chaves = new int[tamanho];
		filhos = new No[tamanho + 1];
	}

	// métodos de acesso da classe 
	public int[] getChaves() {
		return chaves;
	}

	public void setChaves(int[] chaves) {
		this.chaves = chaves;
	}

	public No[] getFilhos() {
		return filhos;
	}

	public void setFilhos(No[] filhos) {
		this.filhos = filhos;
	}

	public boolean isFolha() {
		return folha;
	}

	public void setFolha(boolean folha) {
		this.folha = folha;
	}

	public int getQtdChaves() {
		return qtdChaves;
	}

	public void setQtdChaves(int qtdChaves) {
		this.qtdChaves = qtdChaves;
	}	
	
	// métodos da classe
	public int getChave(int indice) {
		return chaves[indice];
	}
	
	public void setChave(int indice, int valor) {
		chaves[indice] = valor;
	}
	public No getFilho(int indice) {
		return filhos[indice];
	}
	public void setFilho(int indice, No valor) {
		filhos[indice] = valor;
	}
	
	public boolean estaCheia() {
		return(qtdChaves == chaves.length);
	}
	
	public void inserir(int valor, No filho) {
		int lugarCerto = 0;
		boolean encontrei = false;
		
		for (int i = 0 ; i < qtdChaves ; i++) { 			// for de procura ro lugar que a chave vai entrar
			if (chaves[i] > valor) {
				lugarCerto = i;
				encontrei = true;
				break;
			}
		}
		
		if (! encontrei) { // ao inserir numero mt grande
			lugarCerto = qtdChaves;
		}
		
		for(int i = (qtdChaves - 1) ; i >= lugarCerto ; i--) {
			chaves[i + 1] = chaves[i];
			filhos[i + 2] = filhos[i + 1]; // sempre tme um filho a mais q a chave
		}
		chaves[lugarCerto] = valor;
		filhos[lugarCerto + 1] = filho;
		
		qtdChaves++; // linha mais importante do codigo
	}
	
	public String imprimirChaves() {
		String retorno = "";
		
		for (int i = 0 ; i < qtdChaves ; i++) {
			retorno +=(", " + chaves[i]);
		}
		if (retorno.length() > 0) retorno = retorno.substring(2);
		
		return retorno;
	}
}
