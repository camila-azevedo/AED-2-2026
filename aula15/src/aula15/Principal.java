package aula15;

public class Principal {
	public static void main (String [] args) {
		Grafo objGrafo = new Grafo(100);
		
		objGrafo.construir(true);
		objGrafo.imprimir();
		objGrafo.procurarMaiorGrau();
	}
}
