package ListaSite;

public class Main {

	public static void main(String[] args) {
		ListaEncadeadaSite lista = new ListaEncadeadaSite();
		lista.insereInicio("G1","WWW.g1");
		lista.insereInicio("G2","WWW.g2");
		lista.insereFim("G3","G1");
		lista.inserePosicao("G5","G125",4);
		lista.buscarSite("G1");
		//lista.buscarSite("G5");
		lista.imprimirLista();
	}

}
