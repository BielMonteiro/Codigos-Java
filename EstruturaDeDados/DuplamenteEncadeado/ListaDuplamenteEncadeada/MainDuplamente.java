package ListaDuplamenteEncadeada;

public class MainDuplamente {
	public static void main(String[] args) {
		ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
		lista.insereFim(new NoDuplo(150,null,null));
		lista.insereFim(new NoDuplo(12,null,null));
		lista.insereFim(new NoDuplo(15,null,null));
		lista.insereInicio(new NoDuplo(12,null,null));
		lista.insereInicio(new NoDuplo(15,null,null));
		lista.inserePosicao((new NoDuplo(150,null,null)),3);
		lista.inserePosicao((new NoDuplo(15,null,null)),3);
		lista.inserePosicao((new NoDuplo(150,null,null)),5);
		lista.imprimirFila();
		lista.antepenultimo();
		lista.palindromo();
	}

}
