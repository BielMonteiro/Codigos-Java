package ListaEncadeada;

public class Main {

	public static void main(String[] args) {
		ListaEncadeada lista = new ListaEncadeada();
		lista.inserePosicao(50,50);
		lista.inserePosicao(100,1);
		lista.inserePosicao(1000,1);
		lista.inserePosicao(10,4);
		lista.inserePosicao(11,2);
		lista.inserePosicao(15,2);
		lista.inserePosicao(11,1);
		lista.inserePosicao(5,7);
		lista.inserePosicao(4,9);
		lista.removePosicao(2);
		lista.removePosicao(4);
		lista.removePosicao(7);
		lista.removePosicao(3);
		lista.removePosicao(3);
		lista.inserePosicao(50,2);
		lista.inserePosicao(51,3);
		lista.inserePosicao(55,4);
		lista.inserePosicao(50,6);
		lista.inserePosicao(100,6);
		lista.inserePosicao(100,30);
		lista.imprimirLista();
		lista.antepenultimo();
		lista.ordemCrescenteLista();
		lista.imprimirLista();
		lista.ordemDescrecenteLista();
		lista.imprimirLista();
	}

}
