package Pilha;

public class TestePilha implements Pilha {
	
	public Integer[] pilha;
	public static final int tamPilha=5;
	public int pos;
	
	public TestePilha() {
		pilha = new Integer[tamPilha];
		pos=0;
	}

	public Integer insere(Integer valor) {
		if(!pilhaCheia()) {
			pilha[pos++]=valor;
			return valor;
		}
		else
			return null;
	}
	public Integer remove() {
		if(!pilhaVazia()) {
			pilha[--pos]=null;
			return null;
		}
		else
			return null;
	}

	public boolean pilhaVazia() {
		if(pos==0) {
			System.out.println("Pilha Vazia");
			return true;
		}
		else
			return false;
	}

	public boolean pilhaCheia() {
		if(pos==tamPilha) {
			System.out.println("Pilha Cheia");
			return true;
		}
		else
			return false;
	}
	public void imprimirPilha() {
		if(!pilhaVazia()) {
			for (int i = 0; i<pos; i++) {
				System.out.println(pilha[i]);
			}
		}
	}


}
