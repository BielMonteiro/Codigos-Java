package PilhaEncadeada;

public class Main {

	public static void main(String[] args) {
		PilhaEncadeada pilha = new PilhaEncadeada();
		pilha.imprimirFila();
		pilha.insereFim(11);
		pilha.insereFim(12);
		pilha.insereFim(14);
		pilha.insereFim(16);
		pilha.insereFim(14);
		pilha.insereFim(12);
		pilha.insereFim(11);
		pilha.imprimirFila();
		pilha.palindromo();

	}

}
