package Fila;

public class TesteFila implements Fila {
	
	public Integer[] fila;
	public static final int tamFila=5;
	public int pos;
	public TesteFila() {
		fila = new Integer[tamFila];
		pos=-1;
	}

	public Integer insereFinal(Integer valor) {
		if(!filaCheia()) {
			pos++;
			if(pos<tamFila)
				fila[pos]=valor;
		}
		return valor;
		
	}

	public Integer removeInicial() {
		if(!filaVazia()) {
			for (int i = 0; i < pos; i++) {
				if(i<pos)
					fila[i]=fila[i+1];
			}
		}
		fila[pos]=null;
		pos--;
		return 0;
		
	}

	public boolean filaCheia() {
		if(pos==tamFila-1) {
			System.out.println("Fila cheia");
			return true;
		}
		else {
			return false;
		}
	}
	public boolean filaVazia() {
		if(pos==-1)
			return true;
		else
			return false;
	}

	public void imprimirFila() {
		if(filaVazia())
			System.out.println("Fila Vazia");
		else {
			for (int i = 0; i <=pos; i++) {
				System.out.println(fila[i]);
			}
		}
	}

}
