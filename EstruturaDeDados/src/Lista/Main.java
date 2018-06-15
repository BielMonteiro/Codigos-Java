package Lista;

public class Main {

	public static void main(String[] args) {
		TesteLista teste = new TesteLista();
		teste.insereFinal(5);
		teste.insereFinal(10);
		teste.insereFinal(8);
		teste.insereFinal(8);
		teste.insereFinal(10);
		teste.insereFinal(5);
		teste.imprimirLista();
		teste.antePenultimo();
		teste.alterarLista(1);
		teste.palindromo();
		teste.linkUsado(8);
		teste.imprimirLista();
	}

}
