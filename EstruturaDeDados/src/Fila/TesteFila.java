package Fila;

public class TesteFila implements Fila {
	
	public Integer[] fila;
	public static final int tamFila=5;
	public int pos;
	public TesteFila() {
		fila = new Integer[tamFila];
		pos=0;
	}

	public Integer insereFinal(Integer valor) {
		if(!filaCheia()) {
			fila[pos++]=valor;
			return valor;
		}
		else 
			return null;
		
	}

	public Integer removeInicial() {
		if(!filaVazia()) {
			for (int i = 0; i <pos; i++) {
				if(i<pos-1)
					fila[i]=fila[i+1];
			}
		}
		fila[tamFila-1]=null;
		pos--;
		return 0;
		
	}

	public boolean filaCheia() {
		if(pos==tamFila) {
			System.out.println("Fila cheia");
			return true;
		}
		else {
			return false;
		}
	}
	public boolean filaVazia() {
		if(pos==0)
			return true;
		else
			return false;
	}

	public void imprimirFila() {
		if(filaVazia())
			System.out.println("Fila Vazia");
		else {
			for (int i = 0; i <pos; i++) {
				System.out.println(fila[i]);
			}
		}
	}

}
