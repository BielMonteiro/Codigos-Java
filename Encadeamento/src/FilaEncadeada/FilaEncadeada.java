package FilaEncadeada;

public class FilaEncadeada {
	
	private No cabeca;
	private int tamanho;
	
	public FilaEncadeada() {
		cabeca = null;
		tamanho =0;
	}
	public Integer insereFim(Integer valor) {
		if(cabeca == null) {
			cabeca = new No(valor,null);
			return null;
		}
		getCauda().setProximo(new No(valor,null));
		tamanho++;
		return valor;
	}
	public No getCauda() {
		No aux = cabeca;
		if(aux==null)
			return null;
		while(aux.getProximo()!=null) {
			aux=aux.getProximo();
		}
		return aux;
		
	}
	public Integer removeInicio() {
		if(cabeca==null) {
			System.out.println("Não existe elementos para remover.");
			return null;
		}
		cabeca = cabeca.getProximo();
		tamanho--;
		return null;
		
	}
	public void imprimirFila() {
		No aux = cabeca;
		if(cabeca==null) {
			System.out.println("Fila vazia.");
			return;
		}
		for(aux = cabeca;aux!=null;aux=aux.getProximo()) {
			System.out.print(aux.getValor()+" ");
		}
		System.out.println();
	}
	
}
