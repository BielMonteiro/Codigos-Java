package Pilha;

public class Main {
	public static void main(String[] args) {
		TestePilha teste = new TestePilha();
		teste.imprimirPilha();
		teste.insere(1);
		teste.insere(2);
		teste.insere(3);
		teste.insere(4);
		teste.insere(5);
		teste.imprimirPilha();
		teste.insere(50);
		teste.remove();
		teste.remove();
		teste.remove();
		teste.remove();
		teste.remove();
		teste.imprimirPilha();
	}
}
