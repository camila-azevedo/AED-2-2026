package aula11;
public class Arvore {
	// propriedaes da classe
	private No raiz = null;
	private int contador = 0;
	
	// métodos da classe
	public void inserir(int numero) {
		raiz = inserir(raiz, numero);
	}
	private No inserir(No raiz, int numero) {
		// cenário fácil: árvore vazia
		if (raiz == null) {
			return new No(numero, null, null);
		}
		
		// cenário difícil: árvore nao vazia
		if (numero < raiz.getNumero()) {
			raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
		} else {
			raiz.setDireita(inserir(raiz.getDireita(), numero));
		}
		return raiz;
	}
	
	public void procurar (int numero) {
		procurar(raiz, numero);
	}
	 private void procurar(No raiz, int numero) {
		// cenário muito fácil: arvore vazia
		 if (raiz == null) {
				System.out.println("Número não foi encontrado."); 
				System.out.println("Quantidade de tentativas: " + contador);
				contador = 0;
				return;	
		 }
				
		// cenário facil: numero ta na raiz
		 if (raiz.getNumero() == numero) {
				System.out.println("Achei em " + contador + " tentativas");
				contador = 0;
				return;
		}
				
		// cenário dificil
			contador ++;
			if (numero < raiz.getNumero()) {
					procurar(raiz.getEsquerda(), numero);
			} else {
				procurar(raiz.getDireita(), numero);
			}
				
			}
	 
	 public void navegarEmOrdem() {
		 System.out.print("Navegação em-ordem");
		 navegarEmOrdem(raiz);
		 System.out.println();
	 }
	 private void navegarEmOrdem(No raiz) {
		 if (raiz == null) return;
		 
		 navegarEmOrdem(raiz.getEsquerda());
		 System.out.print(raiz.getNumero());
		 navegarEmOrdem(raiz.getDireita());
	 }
}
