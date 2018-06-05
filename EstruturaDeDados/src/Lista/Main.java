package Lista;

public class Main {

	public static void main(String[] args) {
		TesteLista teste = new TesteLista();
		teste.insereFinal(1);
		teste.insereFinal(2);
		teste.insereFinal(3);
		teste.insereFinal(4);
		teste.insereFinal(5);
		teste.insereComeco(5);
		teste.insereFinal(4);
		teste.inserePosicao(50,1);;
		teste.removePosicao(0);
		teste.imprimirLista();
	}

}
