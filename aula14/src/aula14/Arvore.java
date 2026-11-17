package aula14;

public class Arvore {
	// propriedades
	private No raiz = null;

	// método construtor cheio a classe
	public Arvore(int tamanho) {
		raiz = new No(tamanho);
	}

	// métodos da classe
	public void inserir(int numero) {
		RetornoRecursao retorno = inserir(raiz, numero, null);

		if (retorno != null) {
			No novaRaiz = new No(raiz.getChaves().length);
			novaRaiz.setFolha(false);
			novaRaiz.setQtdChaves(1);
			novaRaiz.setChave(0, retorno.getChaveDoMeio());
			novaRaiz.setFilho(0, raiz);
			novaRaiz.setFilho(1, retorno.getFilhoDoMeio());
			raiz = novaRaiz;
		}
	}

	private RetornoRecursao inserir(No raiz, int numero, No filho) {
		// Caso difícil: não é uma folha, tem de procurar a folha certa para inserir
		if ((!raiz.isFolha()) && (filho == null)) {
			int indiceFilho = 0;
			boolean encontrei = false;

			for (int i = 0; i < raiz.getQtdChaves(); i++) { // procurando filho correto para descer
				if (raiz.getChave(i) > numero) {
					indiceFilho = i;
					encontrei = true;
					break;
				}
			}

			if (!encontrei) {
				indiceFilho = raiz.getQtdChaves();
			}
			RetornoRecursao retorno = inserir(raiz.getFilho(indiceFilho), numero, filho); // recursao da descida
			if (retorno != null) {
				retorno = inserir(raiz, retorno.getChaveDoMeio(), retorno.getFilhoDoMeio()); // recursão da subida
			}
			return retorno;
		}
		// Caso fácil: é folha e não esta cheia
		if (!raiz.estaCheia()) {
			raiz.inserir(numero, filho);
			return null;
		}

		// Caso difícil: é folha e esta cheia
		int indiceDoMeio = (raiz.getQtdChaves() / 2);
		int chaveDoMeio = raiz.getChave(indiceDoMeio);
		No novoNo = new No(raiz.getChaves().length);
		novoNo.setFolha(raiz.isFolha());
		
		int novoIndice = 0;
		for (int i = (indiceDoMeio + 1); i < raiz.getQtdChaves(); i++) {
			novoNo.setChave(novoIndice, raiz.getChave(i));
			novoNo.setFilho(novoIndice, raiz.getFilho(i));
			raiz.setChave(i, 0);
			raiz.setFilho(i, null);
			novoIndice++;
		}
		
		novoNo.setFilho(novoIndice, raiz.getFilho(raiz.getQtdChaves()));
		
		raiz.setFilho(raiz.getQtdChaves(), null);
		raiz.setChave(indiceDoMeio, 0);
		
		novoNo.setQtdChaves(indiceDoMeio - ((raiz.getQtdChaves() % 2) == 0 ? 1 : 0));
		raiz.setQtdChaves(indiceDoMeio);
		
		if (numero < chaveDoMeio) {
			raiz.inserir(numero, filho);
		} else {
			novoNo.inserir(numero, filho);
		}
		return new RetornoRecursao(chaveDoMeio, novoNo);
	}
	
	public void imprimir() {
		imprimir(raiz, "");
	}
	
	private void imprimir(No raiz, String indentacao) {
		if (raiz == null) return;
		
		System.out.println(indentacao + raiz.imprimirChaves());
		for (No objFilho : raiz.getFilhos()) {
			imprimir(objFilho, indentacao + "___");
		}
	}
}
