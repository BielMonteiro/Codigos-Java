package Fila;

public class Main {

	public static void main(String[] args) {
		TesteFila teste = new TesteFila();
		teste.imprimirFila();
		teste.insereFinal(1);
		teste.insereFinal(2);
		teste.insereFinal(3);
		teste.insereFinal(4);
		teste.insereFinal(5);
		teste.imprimirFila();
		teste.insereFinal(50);
		teste.removeInicial();
		teste.imprimirFila();
	}

}
