package ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada {
	
	private No head;
	private No tail;
	private int tamanho;
	
	public ListaDuplamenteEncadeada() {
		head=new No(null,tail,null);
		tail=new No(null,null,head);
		tamanho =0;
	}
	public Integer insereFim(No valor) {
		if(listaVazia(valor)==true)
			return null;
		valor.setAnterior(tail.getAnterior());
		tail.getAnterior().setProximo(valor);
		tail.setAnterior(valor);
		valor.setProximo(tail);
		tamanho++;
		return valor.getValor();
	}
	public Integer inserePosicao(No valor,int posicao) {
		No aux = head;
		if(listaVazia(valor)==true)
			return null;
		if(posicao==1)
			insereInicio(valor);
		else if(posicao==tamanho+1)
			insereFim(valor);
		else if(posicao<=0 || posicao>tamanho)
			System.out.println("Posição não existe");
		else {
			for (int i = 0; i <posicao-1; i++) {
				aux=aux.getProximo();
			}
			No aux2=aux;
			valor.setAnterior(aux);
			valor.setProximo(aux.getProximo());
			aux.getProximo().setAnterior(valor);
			aux.setProximo(valor);
			tamanho++;
		}
		return valor.getValor();
	}
	public Integer insereInicio(No valor) {
		if(listaVazia(valor)==true)
			return null;
		valor.setAnterior(head);
		valor.setProximo(head.getProximo());
		head.getProximo().setAnterior(valor);
		head.setProximo(valor);
		tamanho++;
		return valor.getValor();
	}
	public Integer removeFim() {
		No aux = tail.getAnterior();
		No substituto = tail.getAnterior().getAnterior();
		if(tamanho==0) {
			System.out.println("Não existe elementos para remover.");
			return null;
		}
		tail.setAnterior(substituto);
		substituto.setProximo(tail);
		tamanho--;
		return aux.getValor();
		
	}
	public Integer removeInicio() {
		No aux = head.getProximo();
		No substituto = head.getProximo().getProximo();
		if(tamanho==0) {
			System.out.println("Não existe elementos para remover.");
			return null;
		}
		head.setProximo(substituto);
		substituto.setAnterior(head);
		tamanho--;
		return aux.getValor();
	}
	public Integer removePosicao(int posicao) {
		No aux = head;
		if(posicao==1)
			removeInicio();
		else if(posicao==tamanho)
			removeFim();
		else if(posicao<=0 || posicao>tamanho)
			System.out.println("Posição não existe");
		else {
			for (int i = 0; i <posicao; i++) {
				aux=aux.getProximo();
			}
			aux.getProximo().setAnterior(aux.getAnterior());
			aux.getAnterior().setProximo(aux.getProximo());
			
			aux.setAnterior(null);
			aux.setProximo(null);
			tamanho--;
		}
		return aux.getValor();
	}
	public boolean listaVazia(No valor) {
		if(tamanho == 0) {
			head.setProximo(valor);
			valor.setAnterior(head);
			valor.setProximo(tail);
			tail.setAnterior(valor);
			tamanho++;
			return true;
		}
		return false;
	}
	
	public void imprimirFila() {
		int i=0;
		if(tamanho==0) {
			System.out.println("Lista vazia.");
			return;
		}
		for(No aux = head;aux!=null;aux=aux.getProximo()) {
			if(i==0&&aux.getValor()==null) {
				System.out.print("Head >> ");
				i=1;
			}
			else if(i==1&&aux.getValor()==null) {
				System.out.print(" << Tail");
			}
			else
				System.out.print(" <<"+aux.getValor()+">> ");
		}
	}
	
}
