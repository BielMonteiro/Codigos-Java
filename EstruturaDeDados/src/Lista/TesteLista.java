package Lista;

public class TesteLista implements Lista {
	public Integer[] lista;
	public static final int tamLista=6;
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
	
	public Integer insereOrdenada(Integer valor) {
		int maior=lista[0];
		int indice=0;
		int flag=0;
		if(!listaCheia()) {
			if(pos == -1)
				insereComeco(valor);
			else{
				int aux = 0;
				for (int i=0; i<=pos; i++){
					if(lista[i]>valor){
						aux = i;
						for (int j=aux+1; j<=pos; j++){
							if(lista[j]<lista[aux]&& lista[j]>valor) {
								aux = j;
								flag=1;
							}
						}
						inserePosicao(valor, aux+1);
						return null;
					}
					if(lista[i]>maior){
						indice=i;
						maior=lista[i];
					}
				}
			}
			if(flag==0)
				inserePosicao(valor,indice+2);
		}
		return null;
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
	public void ordenaLista() {
		int aux;
		if(!listaVazia()) {
			for (int i = 0; i <=pos; i++) {
				for (int j = i; j <=pos; j++) {
					if(lista[i]>lista[j]) {
						aux=lista[j];
						lista[j]=lista[i];
						lista[i]=aux;
					}
				}
			}
		}
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
	public void antePenultimo() {
		if(pos-2<0)
			System.out.println("Não existe Antepenultimo");
		else
			System.out.println("O antepenultimo é: "+lista[pos-2]);
	}
	public void imprimirLista() {
		if(!listaVazia()) {
			for (int i = 0; i <=pos; i++) {
				System.out.print(lista[i]+" ");
			}
			System.out.println();
		}
	}
	public void alterarLista(int x) {
		if(x==0) {
			for (int i = 0; i <=pos; i++) {
				System.out.print(lista[pos-i]+" ");
			}
			System.out.println();
		}
		else if(x==1){
				for (int i = 0; i <=pos; i++) {
					if(i!=0)
						System.out.print(lista[i]+" ");
				}
			System.out.print(lista[0]+"\n");
		}
		else
			System.out.println("Opção inválida");
		
	}
	public void palindromo() {
		int cont=0;
		for (int i = 0; i <=(pos/2); i++) {
			if(lista[i].equals(lista[pos-i]))
				cont++;
		}
		if(cont==(pos/2)+1)
			System.out.println("É um Palindromo");
		else
			System.out.println("Não é um Palindromo");
	}
	public void linkUsado(int nome) {
		int indice=-1;
		for (int i = 0; i <=pos; i++) {
			if(lista[i].equals(nome)) {
				indice=i;
				break;
			}
		}
		if(indice!=-1) {
			removePosicao(indice+1);  //Se o elemento existir no vetor
			insereComeco(nome);
		}
	}
}
