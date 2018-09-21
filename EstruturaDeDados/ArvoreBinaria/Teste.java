
public class Teste {

	public static void main(String[] args) {
		BinaryTree arvore = new BinaryTree();
		arvore.inserir(20);
		arvore.inserir(50);
		arvore.inserir(10);
		arvore.inserir(5);
		arvore.inserir(12);
		arvore.inserir(1);
		arvore.inserir(15);
		arvore.inserir(14);
		arvore.inserir(13);
		arvore.inserir(11);
		arvore.inserir(6);
		System.out.println();
		arvore.imprimirPrefixado();
		arvore.remove2(arvore.raiz,10);
		System.out.println();
		arvore.imprimirPrefixado();
		arvore.remove2(arvore.raiz,6);
		System.out.println();
		arvore.imprimirPrefixado();
	}

}
