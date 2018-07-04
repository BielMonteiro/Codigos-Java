package Lista;
public interface Lista {
	/*
	 Operacoes principais
	 */
	public Integer insereFinal(Integer valor);
	public Integer insereComeco(Integer valor);
	public Integer inserePosicao(Integer valor,Integer valor2);
	public Integer insereOrdenada(Integer valor);
	public Integer removeInicial();
	public Integer removeFinal();
	public Integer removePosicao(Integer valor);
	
	/*
	 Operacoes auxiliares
	 */
	public void linkUsado(int nome);
	public void palindromo();
	public void alterarLista(int x);
	public void antePenultimo();
	public void ordenaLista();
	public boolean listaVazia();
	public boolean listaCheia();
	public void imprimirLista();
}