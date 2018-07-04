package Pilha;
public interface Pilha {
	/*
	 Operacoes principais
	 */
	public Integer insere(Integer valor);
	public Integer remove();
	
	/*
	 Operacoes auxiliares
	 */
	public boolean pilhaVazia();
	public boolean pilhaCheia();
	public void imprimirPilha();
}