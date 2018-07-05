package FilaEncadeada;

public class Main {

	public static void main(String[] args) {
		FilaEncadeada fila = new FilaEncadeada();
		fila.imprimirFila();
		fila.insereFim(10);
		fila.insereFim(15);
		fila.insereFim(14);
		fila.insereFim(13);
		fila.insereFim(12);
		fila.removeInicio();
		fila.imprimirFila();

	}

}
