package aula14;

public class Principal {
	public static void main (String [] args) {
		int tamanho = 1000;
		Arvore objArvore = new Arvore(5);
		
		for (int i = 0 ; i < tamanho ; i++) {
			objArvore.inserir((int) (tamanho * Math.random()));
		}
		
		objArvore.imprimir();
	}
}
