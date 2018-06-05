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
		if(!listaCheia()) 
			pos++;
		else {
			for (int i = 0; i < pos; i++) {
				if(i<pos)
					lista[i]=lista[i+1];
			}
		}
		lista[pos]=valor;
		return valor;
	}

	public Integer insereComeco(Integer valor) {
		if(!listaCheia())
			pos++;
		for (int i = pos-1; i > 0; i--) {
			if(i>0)
				lista[i]=lista[i-1];
		}
		lista[0]=valor;
		return valor;
	}

	public Integer inserePosicao(Integer valor,Integer valor2) {
		if(lista[valor2-1]==null)
			pos++;
		lista[valor2-1]=valor;
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
			lista[pos]=null;
			pos--;
		}
		return null;
	}

	public Integer removePosicao(Integer valor) {
		if(valor>0&&(valor-1<=pos)&&(valor<=tamLista)) {
			if(!listaVazia()) {
				for (int i = valor-1; i < pos; i++) {
					if(i<pos)
						lista[i]=lista[i+1];
				}
				lista[pos]=null;
				pos--;
			}
		}
		else
			System.out.println("O Valor esta fora do interval [1,5] ou é maior que o tamanho atual da lista");	
		return null;
	}

	public boolean listaVazia() {
		if(pos==-1)
			return true;
		else
			return false;
	}

	public boolean listaCheia() {
		if(pos==tamLista-1)
			return true;
		else
			return false;
	}

	public void imprimirLista() {
		if(listaVazia())
			System.out.println("Lista Vazia");
		else {
			for (int i = 0; i <=pos; i++) {
				System.out.println(lista[i]);
			}
		}

	}

}
