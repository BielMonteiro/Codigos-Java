package ListaDuplamenteEncadeada;

public class ListaDuplamenteEncadeada {
	
	private NoDuplo head;
	private NoDuplo tail;
	private int tamanho;
	
	public ListaDuplamenteEncadeada() {
		head=new NoDuplo(null,tail,null);
		tail=new NoDuplo(null,null,head);
		tamanho =0;
	}
	public Integer insereFim(NoDuplo valor) {
		if(listaVazia(valor)==true)
			return null;
		valor.setAnterior(tail.getAnterior());
		tail.getAnterior().setProximo(valor);
		tail.setAnterior(valor);
		valor.setProximo(tail);
		tamanho++;
		return valor.getValor();
	}
	public Integer inserePosicao(NoDuplo valor,int posicao) {
		NoDuplo aux = head;
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
			NoDuplo aux2=aux;
			valor.setAnterior(aux);
			valor.setProximo(aux.getProximo());
			aux.getProximo().setAnterior(valor);
			aux.setProximo(valor);
			tamanho++;
		}
		return valor.getValor();
	}
	public Integer insereInicio(NoDuplo valor) {
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
		NoDuplo aux = tail.getAnterior();
		NoDuplo substituto = tail.getAnterior().getAnterior();
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
		NoDuplo aux = head.getProximo();
		NoDuplo substituto = head.getProximo().getProximo();
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
		NoDuplo aux = head;
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
	public boolean listaVazia(NoDuplo valor) {
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
	public void ordemCrescenteLista() {
		if(tamanho!=0) {
			for (NoDuplo aux = head.getProximo();aux.getValor()!=null;aux=aux.getProximo()) {
				for (NoDuplo aux2 = aux.getProximo();aux2.getValor()!=null;aux2=aux2.getProximo()) {
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
			for (NoDuplo aux = head.getProximo();aux.getValor()!=null;aux=aux.getProximo()) {
				for (NoDuplo aux2 = aux.getProximo();aux2.getValor()!=null;aux2=aux2.getProximo()) {
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
	public void antepenultimo() {
		NoDuplo aux=head;
		if(tamanho<3)
			System.out.println("Não existe antepenúltimo");
		else
			for (aux = head;aux.getProximo().getProximo().getProximo().getProximo()!=null;aux =aux.getProximo()) {
			}
		System.out.println("Esse é o antePenultimo: "+aux.getValor());
	}
	public void palindromo() {
		NoDuplo aux=head.getProximo();
		NoDuplo aux2 = tail.getAnterior();
		int i = 0;
		int iguais=0;
		while(i < (tamanho/2)) {
			if(aux.getValor().equals(aux2.getValor()))
				iguais++;
			i++;
			aux=aux.getProximo();
			aux2=aux2.getAnterior();
		}
		if(i==iguais)
			System.out.println("É um Palindromo");
		else
			System.out.println("Não é um Palindromo");
	}
	public void imprimirFila() {
		int i=0;
		if(tamanho==0) {
			System.out.println("Lista vazia.");
			return;
		}
		for(NoDuplo aux = head;aux!=null;aux=aux.getProximo()) {
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
		System.out.println();
	}
	
}
