package aula15;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Grafo {
	// propriedades da classe
	private boolean[][] matrizAdjacencia = null ; // matriz q diz quais vertices estão conectados
	
	// método construtor cheio da classe
	public Grafo(int qtdVertices) {
		matrizAdjacencia = new boolean[qtdVertices][qtdVertices]; // alocacao dinamica de memória
	}
	
	// método da classe
	public void construir(boolean aleatorio) {
		boolean adjacencia = false;
		
		for (int i = 0 ; i < matrizAdjacencia.length -1 ; i++) { // i linhas - vertice 0 ate o penultimo
			for (int j = (i + 1) ; j < matrizAdjacencia.length ; j++) { // j colunas - vertice depois do i 
				// navegacao é so pela diagonal superior
				if (aleatorio) {
					adjacencia = (((int) (3 * Math.random())) == 0);
				} else {
					BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
					try {
						System.out.print("Digite <S> se " + i + " for adjacente a " + j + ": ");
						adjacencia = leitor.readLine().equalsIgnoreCase("s");
					} catch (Exception e) {}
				}
				matrizAdjacencia[i][j] = adjacencia;
				matrizAdjacencia[j][i] = adjacencia;
			}
		}
	}
	 
	public void imprimir() {
		System.out.println("Vértice \t Vizinhança");
		for (int i = 0 ; i < matrizAdjacencia.length ; i++) {
			System.out.print(i + " \t\t ");
			for (int j = 0 ; j < matrizAdjacencia.length ; j++) {
				if (matrizAdjacencia[i][j]) {
					System.out.print(j + ", ");
				}
			}
			System.out.println();
		}
	}
	
	public void procurarMaiorGrau() {
		int vertice = 0;
		int maiorGrau = 0;
		
		for (int i = 0 ; i < matrizAdjacencia.length ; i++) {
			int contador = 0;
			for (int j = 0 ; j < matrizAdjacencia.length ; j++) {
				if (matrizAdjacencia[i][j]) {
					contador ++;
				}
			}
			if (contador > maiorGrau) {
				vertice = i;
				maiorGrau = contador;
			}
		}
		System.out.println("O vértice mais popular é o " + vertice + ". " + "Ele tem grau " + maiorGrau + ".");
	}
}
