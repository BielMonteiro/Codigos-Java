package memoriaCache;

import java.io.*;
//Algumas das variaveis que criadas
public class TesteCache {
	private String tag;
	private String index;
	private String offset;
	private File file;
	private int tCache=-1;
	private int way=-1;
	private String[][] cache;
	private int[][] indice;
	private int indiceT=0;
	private int miss=0;
	private int hit=0;
	private String metodo;
	int t1;
	
	TesteCache(File arq,int x,int way,String metodo){
		//Aqui Separo o tamanho da cache, a quantidade de colunas, inicio as matrizes com o tamanho da cache X ways.
		int y1=way;
		this.file = arq;
		while(x>0) {
			x=x/2;
			this.tCache++;
		}
		while(y1>0) {
			y1=y1/2;
			this.way++;
		}
		this.tCache=(this.tCache)-(4+this.way);
		t1 =(int) Math.pow(2,(this.tCache));
		this.way=way;
		this.cache = new String[t1][way];
		this.indice = new int[t1][way];
		this.metodo=metodo;
				
	}
	
	public void resultado() throws IOException {
		try {			
			//Aqui crio um objeto de FileReader junto com um BufferedREader para ler o Arquivo passado no contrutor
			FileReader fr = new FileReader(this.file);
			BufferedReader br = new BufferedReader(fr);
			String i;
			//Aqui vai lendo linha por linha do arquivo e separando cada coisa.(tag, index e offset)
			while((i = br.readLine())!=null) {
				int ii=0;
				String x = HexBin.converter(i);
				this.tag= x.substring(0,32-(this.tCache+4));
				this.index = x.substring(32-(this.tCache+4),28);
				this.offset = x.substring(28,32);
				//Aqui é o metodo Direto
				if(this.way==1) {
					//Testa se a posição é vazia, senão for, testa a tag do index passado. Se for igual é hit, senão é miss
					if(this.cache[Integer.parseInt(this.index, 2)][0]!=null) {
						if(this.cache[Integer.parseInt(this.index, 2)][0].equals(this.tag)) {
							this.hit++;
						}
						else {
							this.miss++;
							this.cache[Integer.parseInt(this.index, 2)][0]=this.tag;
						}
					}
					//Aqui se a posição for vazia so da miss e adiciona a tag
					else {
						this.miss++;
						this.cache[Integer.parseInt(this.index,2)][0]=this.tag;
					}
				}
				//Aqui é o Fifo/Lru
				else if(this.way>1) {
					//Crio duas variaveis que vão pegar a coluna e o indice do que esta mais tempo no index informado, para
					//depois se a linha encher antes da cache ele substituir o mais antigo
					int t=this.indice[Integer.parseInt(this.index,2)][0];
					int v=0;
					for (int j = 0; j <way; j++) {
						//Se a variavel ii == 1 ele sempre vai dar break, quer dizer que alguma operação foi feita
						if(ii==1) {
							break;
						}
						//Aqui se for diferente de zero ele compara as tag no index passado, se for igual da hit.(No metodo Lru 
						//quando da hit a tag que esta a mais tempo e for acessada ela meio que é "salva" deixa de ser a mais antiga
						//No Fifo não ocorre isso, por isso implementei esse if para só realizar a operação se for LRU
						if(this.cache[Integer.parseInt(this.index,2)][j]!=null) {
							if(this.cache[Integer.parseInt(this.index,2)][j].equals(tag)) {
								if(this.metodo.equals("Lru")) {
									int in = this.indice[Integer.parseInt(this.index,2)][j];
									for (int k = 0; k < this.indice.length; k++) {
										for (int k2 = 0; k2 <this.way; k2++) {
											if(this.indice[k][k2]>in) {
												this.indice[k][k2]--;
											}
										}
									}
									this.indice[Integer.parseInt(this.index,2)][j]=this.indiceT;
								}
								this.hit+=1;
								ii=1;
							}
							//Aqui esse if sempre é acessado, porque ele vai pegar o indice do mais antigo na linha. Por isso o for
							if(this.indice[Integer.parseInt(this.index,2)][j]<t) {
								t=this.indice[Integer.parseInt(this.index,2)][j];
								v=j;
							}
						}
						//Aqui se for vazio ele da miss adiciona a tag e o indice e logo após incrementa.
						else if(this.cache[Integer.parseInt(this.index,2)][j]==null) {
							this.cache[Integer.parseInt(this.index,2)][j]=this.tag;
							this.miss++;
							this.indice[Integer.parseInt(this.index,2)][j]=this.indiceT;
							this.indiceT++;
							ii=1;
						}
					}
					//Aqui se nenhum dos if foi acessado, quer dizer que deu miss por falta da tag. Logo como eu ja tenho a coluna e
					//o valor do indice eu posso "modificar" a matriz de indices que é reponsavel por controla a chegada das tag,
					//com isso atualizo a matriz das tag e dos indices
					if(ii==0) {
						for (int j = 0; j <this.indice.length; j++) {
							for (int j2 = 0; j2 < way; j2++) {
								if(this.indice[j][j2]>t) {
									this.indice[j][j2]--;
								}
							}
						}
						this.cache[Integer.parseInt(this.index,2)][v]=this.tag;
						this.indice[Integer.parseInt(this.index,2)][v]=this.indiceT;
						this.miss++;
					}
				}
			}
			//Aqui dou um print dos hits e miss
			System.out.println("Quantidade de hits: "+this.hit);
			System.out.println("Quantidade de miss: "+this.miss);
			br.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
