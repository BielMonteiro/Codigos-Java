package ListaEncadeada;


public class ListaEncadeada {
	
	private No cabeca;
	private int tamanho;
	
	public ListaEncadeada() {
		cabeca = null;
		tamanho =0;
	}
	public Integer insereFim(Integer valor) {
		if(listaVazia(valor)==true)
			return valor;
		getCauda().setProximo(new No(valor,null));
		tamanho++;
		return valor;
	}
	public Integer inserePosicao(Integer valor,int posicao) {
		No aux = cabeca;
		if(listaVazia(valor)==true)
			return valor;
		if(posicao==1)
			insereInicio(valor);
		else if(posicao==tamanho+1)
			insereFim(valor);
		else if(posicao<=0 || posicao>tamanho)
			System.out.println("Posição não existe");
		else {
			for (int i = 0; i <posicao-2; i++) {
				aux=aux.getProximo();
			}
			No aux2=aux;
			aux2.setProximo(new No(valor,aux.getProximo()));
			tamanho++;
		}
		return valor;
	}
	public Integer insereInicio(Integer valor) {
		if(listaVazia(valor)==true)
			return valor;
		No aux=cabeca;
		cabeca=new No(valor,null);
		cabeca.setProximo(aux);
		tamanho++;
		return valor;
	}
	public Integer removeFim() {
		No aux = cabeca;
		if(getCauda()==null) {
			System.out.println("Não existe elementos para remover.");
			return null;
		}
		getPenultimo().setProximo(null);
		tamanho--;
		return aux.getValor();
		
	}
	public Integer removeInicio() {
		No aux = cabeca;
		if(cabeca==null) {
			System.out.println("Não existe elementos para remover.");
			return null;
		}
		cabeca = cabeca.getProximo();
		tamanho--;
		return aux.getValor();
	}
	public Integer removePosicao(int posicao) {
		No aux = cabeca;
		if(posicao==1)
			removeInicio();
		else if(posicao==tamanho)
			removeFim();
		else if(posicao<=0 || posicao>tamanho)
			System.out.println("Posição não existe");
		else {
			for (int i = 0; i <posicao-2; i++) {
				aux=aux.getProximo();
			}
			No aux2=aux;
			aux2.setProximo(aux.getProximo().getProximo());
			tamanho--;
		}
		return aux.getValor();
	}
	public No getPenultimo(){
		No aux = cabeca;
		if(aux == null){
			return null;
		}
		while(aux.getProximo().getProximo() != null){
			aux = aux.getProximo();
		}
		return aux;
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
	public boolean listaVazia(Integer valor) {
		if(cabeca == null) {
			cabeca = new No(valor,null);
			tamanho++;
			return true;
		}
		return false;
	}
	
	public void imprimirFila() {
		No aux = cabeca;
		if(cabeca==null) {
			System.out.println("Lista vazia.");
			return;
		}
		for(aux = cabeca;aux!=null;aux=aux.getProximo()) {
			System.out.print(aux.getValor()+" ");
		}
		//System.out.println();
	}
	
}
