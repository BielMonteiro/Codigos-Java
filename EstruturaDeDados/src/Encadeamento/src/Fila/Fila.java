package Fila;
public interface Fila {
	/*
	 Operacoes principais
	 */
	public Integer insereFinal(Integer valor);
	public Integer removeInicial();
	
	/*
	 Operacoes auxiliares
	 */
	public boolean filaVazia();
	public boolean filaCheia();
	public void imprimirFila();
}
