package aula10;

public class Principal {
	public static void main (String [] args) {
		Arvore objArvore = new Arvore();
		
		for (int i = 0 ; i < 25 ; i++) {
			objArvore.inserir(i);
		}
		objArvore.navegarPreOrdem();
		objArvore.navegarEmOrdem();
		objArvore.navegarPosOrdem();
	}
}
