package ListaDuplamenteEncadeada;

public class MainDuplamente {
	public static void main(String[] args) {
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		lista.insereFim(new No(10,null,null));
		lista.insereFim(new No(12,null,null));
		lista.insereFim(new No(15,null,null));
		lista.insereInicio(new No(1,null,null));
		lista.insereInicio(new No(0,null,null));
		lista.inserePosicao((new No(50,null,null)),3);
		lista.inserePosicao((new No(500,null,null)),5);
		lista.removePosicao(3);
		lista.imprimirFila();
	}

}
