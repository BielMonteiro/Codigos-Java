package PilhaEncadeada;

public class PilhaEncadeada {
	
	private No cabeca;
	private int tamanho;
	
	public PilhaEncadeada() {
		cabeca = null;
		tamanho =0;
	}
	public Integer insereFim(Integer valor) {
		if(cabeca == null) {
			cabeca = new No(valor,null);
			tamanho++;
			return valor;
		}
		//getCauda().setProximo(new No(valor,null));
		No aux=cabeca;
		cabeca=new No(valor,null);
		cabeca.setProximo(aux);
		tamanho++;
		return valor;
	}
	public Integer removeFinal() {
		if(cabeca==null) {
			System.out.println("Não existe elementos para remover.");
			return null;
		}
		No aux=cabeca;
		cabeca = cabeca.getProximo();
		tamanho--;
		
		return aux.getValor();
		
	}
	public void palindromo() {
		int acerto=0;
		PilhaEncadeada stack =new PilhaEncadeada();
		No aux=cabeca;
		int i=0;
		for(aux=cabeca;aux!=null;aux=aux.getProximo()) {
			if(i==tamanho/2)
				break;
			i++;
			stack.insereFim(aux.getValor());
		}
		if(tamanho%2!=0)
			aux=aux.getProximo();
		for(aux=aux;aux!=null;aux=aux.getProximo()) {
			if(aux.getValor().equals(stack.removeFinal()))
				acerto++;
		}
		if(i==acerto)
			System.out.println("É um Palindromo");
		else
			System.out.println("Não é um Palindromo");
		
	}
	public No getCauda(){
			
			No aux = cabeca;
			
			if(aux == null){
				return null;
			}
			
			while(aux.getProximo() != null){
				aux = aux.getProximo();
			}
			return aux;
	}
	public void imprimirFila() {
		No aux = cabeca;
		if(cabeca==null) {
			System.out.println("Pilha vazia.");
			return;
		}
		for(aux = cabeca;aux!=null;aux=aux.getProximo()) {
			System.out.println(aux.getValor());
		}
		System.out.println();
	}
	
}
