package ListaEncadeada;

public class ListaEncadeada implements ListaEncadeadaSimples{
	
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
	public void antepenultimo() {
		No aux=cabeca;
		if(tamanho<3)
			System.out.println("Não existe antepenúltimo");
		else
			for (aux = cabeca;aux.getProximo().getProximo().getProximo()!=null;aux =aux.getProximo()) {
				
			}
		System.out.println("Esse é o antePenultimo: "+aux.getValor());
	}
	public void ordemCrescenteLista() {
		if(tamanho!=0) {
			for (No aux = cabeca;aux!=null;aux=aux.getProximo()) {
				for (No aux2 = aux.getProximo();aux2!=null;aux2=aux2.getProximo()) {
					Integer aux3;
					if(aux.getValor()>aux2.getValor()) {
						aux3=aux.getValor();
						aux.setValor(aux2.getValor());
						aux2.setValor(aux3);
					}
				}
			}
		}
	}
	public void ordemDescrecenteLista() {
		if(tamanho!=0) {
			for (No aux = cabeca;aux!=null;aux=aux.getProximo()) {
				for (No aux2 = aux.getProximo();aux2!=null;aux2=aux2.getProximo()) {
					Integer aux3;
					if(aux.getValor()<aux2.getValor()) {
						aux3=aux.getValor();
						aux.setValor(aux2.getValor());
						aux2.setValor(aux3);
					}
				}
			}
		}
	}
	public boolean listaVazia(Integer valor) {
		if(cabeca == null) {
			cabeca = new No(valor,null);
			tamanho++;
			return true;
		}
		return false;
	}
	
	public void imprimirLista() {
		No aux = cabeca;
		if(cabeca==null) {
			System.out.println("Lista vazia.");
			return;
		}
		for(aux = cabeca;aux!=null;aux=aux.getProximo()) {
			System.out.print(aux.getValor()+" ");
		}
		System.out.println();
	}
	@Override
	public Integer insereOrdenada(Integer valor) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void linkUsado(int nome) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void palindromo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void alterarLista(int x) {
		// TODO Auto-generated method stub
		
	}
	
}
