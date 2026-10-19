package aula11;

import java.util.Scanner;

public class Principal {
	public static void main (String [] args) {
		// declaração e variáveis
		Scanner leitor = new Scanner(System.in);
		Arvore objArvore = new Arvore();
		
		// Construção da árvore
		int tamanho = 1000;
		for (int i = 0 ; i < tamanho; i++) {
			objArvore.inserir((int) (tamanho * Math.random()));
		}
		
		// Realização de pesquisas
		int numero = 0;
		do {
			System.out.print("Digite um número: ");
			numero = leitor.nextInt();
			objArvore.procurar(numero);
		} while (numero != -99);
		leitor.close();
		
		// Impressão ordenada
		objArvore.navegarEmOrdem();
	}
}
