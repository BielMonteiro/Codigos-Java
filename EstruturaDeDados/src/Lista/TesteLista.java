package Lista;

public class TesteLista implements Lista {
	public Integer[] lista;
	public static final int tamLista=5;
	public int pos;
	public TesteLista() {
		lista = new Integer[tamLista];
		pos=-1;
	}
	public Integer insereFinal(Integer valor) {
		if(!listaCheia()) {
			pos++;
			lista[pos]=valor;
		}
		return valor;
	}
	public Integer insereComeco(Integer valor) {
		if(!listaCheia()) {
			pos++;
			for (int i = pos; i > 0; i--) {
				if(i>0)
					lista[i]=lista[i-1];
			}
			lista[0]=valor;
		}
		return valor;
	}
	public Integer inserePosicao(Integer valor,Integer valor2) {
		if(!listaCheia()) {
			if(valor2>tamLista||valor2<=0) 
				System.out.println("O Valor esta fora do interval [1,5]");
			else if(valor2-1<=pos) {
				pos++;
				for (int i = pos; i > valor2-1; i--) {
					lista[i]=lista[i-1];
				}
				lista[valor2-1]=valor;
			}
			else {
				pos++;
				lista[pos]=valor;
			}	
		}
		return valor;
	}
	public Integer removeInicial() {
		if(!listaVazia()) {
			for (int i = 0; i < pos; i++) {
				if(i<pos)
					lista[i]=lista[i+1];
			}
			lista[pos]=null;
			pos--;
		}
		return 0;
	}
	public Integer removeFinal() {
		if(!listaVazia()) {
			if(lista[pos]!=null) {
				lista[pos]=null;
				pos--;
			}
			else
				System.out.println("Posição Vazia");
		}
		return null;
	}
	public Integer removePosicao(Integer valor) {
		if(valor>0&&(valor<=tamLista)) {
			if(!listaVazia()) {
				if(lista[valor-1]!=null) {
					for (int i = valor-1; i < pos; i++) {
						if(i<pos)
							lista[i]=lista[i+1];
					}
					lista[pos]=null;
					pos--;
				}
				else
					System.out.println("Posição Vazia");
			}
		}
		else
			System.out.println("O Valor esta fora do interval [1,5]");	
		return null;
	}
	public boolean listaVazia() {
		if(pos==-1) {
			System.out.println("Lista Vazia");
			return true;
		}
		else
			return false;
	}
	public boolean listaCheia() {
		if(pos==tamLista-1) {
			System.out.println("lista Cheia");
			return true;
		}
		else
			return false;
	}
	public void imprimirLista() {
		if(!listaVazia()) {
			for (int i = 0; i <=pos; i++) {
				System.out.println(lista[i]);
			}
		}
	}
}
