package PilhaEncadeada;

public class Main {

	public static void main(String[] args) {
		PilhaEncadeada pilha = new PilhaEncadeada();
		pilha.imprimirFila();
		pilha.insereFim(10);
		pilha.insereFim(15);
		pilha.insereFim(14);
		pilha.insereFim(13);
		pilha.insereFim(12);
		pilha.removeFinal();
		pilha.imprimirFila();
		//System.out.println();

	}

}
