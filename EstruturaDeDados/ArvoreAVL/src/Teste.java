
public class Teste {

	public static void main(String[] args) {
		AVLTree arvore = new AVLTree();
		arvore.insere(20);
		arvore.insere(14);
		arvore.insere(12);
		arvore.insere(8);
		arvore.insere(10);
		System.out.println();
		arvore.imprimirPrefixado();
		arvore.removerNo(12);
		System.out.println();
		arvore.imprimirPrefixado();
	}

}
