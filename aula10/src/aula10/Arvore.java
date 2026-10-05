package aula10;

public class Arvore {
	// propriedades da classe
	private No raiz = null;
	
	// métodos da classe
	public void inserir (int numero) { // método fake
		raiz = inserir(raiz, numero);
	}
	
	private No inserir(No raiz, int numero) { // método de verdade
		// caso fácil: arvore vazia
		if (raiz == null) {
			return new No(numero, null, null);
		}
		
		// cenário dificil: árvore nao vazia
		boolean sorteio = ((int) (2 * Math.random()) == 0);
		
		if (sorteio) {
			raiz.setEsquerda(inserir(raiz.getEsquerda(), numero));
		} else {
			raiz.setDireita(inserir(raiz.getDireita(), numero));
		}
		return raiz;
	}
	// pré-ordem
	public void navegarPreOrdem() {
		System.out.print("Pré-Ordem: ");
		navegarPreOrdem(raiz);
		System.out.println();
	}
	
	private void navegarPreOrdem(No raiz) {
		if (raiz == null) return;
		
		System.out.print(raiz.getNumero() + ", ");
		navegarPreOrdem(raiz.getEsquerda());
		navegarPreOrdem(raiz.getDireita());
	}
	
	// em ordem
	public void navegarEmOrdem() {
		System.out.print("Em-Ordem:  ");
		navegarEmOrdem(raiz);
		System.out.println();
	}
	
	private void navegarEmOrdem(No raiz) {
		if (raiz == null) return;
		
		navegarEmOrdem(raiz.getEsquerda());
		System.out.print(raiz.getNumero() + ", ");
		navegarEmOrdem(raiz.getDireita());
	}
	// pós-ordem
	public void navegarPosOrdem() {
		System.out.print("Pós-Ordem: ");
		navegarPosOrdem(raiz);
		System.out.println();
	}
	
	private void navegarPosOrdem(No raiz) {
		if (raiz == null) return;
		
		navegarPosOrdem(raiz.getEsquerda());
		navegarPosOrdem(raiz.getDireita());
		System.out.print(raiz.getNumero() + ", ");
	}
}
