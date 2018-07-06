package ListaEncadeada;
public interface ListaEncadeadaSimples {
	/*
	 Operacoes principais
	 */
	public Integer insereFim(Integer valor);
	public Integer insereInicio(Integer valor);
	public Integer inserePosicao(Integer valor,int posicao);
	public Integer insereOrdenada(Integer valor);
	public Integer removeInicio();
	public Integer removeFim();
	public Integer removePosicao(int valor);
	
	/*
	 Operacoes auxiliares
	 */
	public void ordemCrescenteLista();
	public void ordemDescrecenteLista();
	public void antepenultimo();
	public No getCauda();
	public No getPenultimo();
	public void linkUsado(int nome);
	public void palindromo();
	public void alterarLista(int x);
	public boolean listaVazia(Integer valor);
	public void imprimirLista();
}