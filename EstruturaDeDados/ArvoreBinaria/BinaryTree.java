
public class BinaryTree<E> {
	static int cont=0;
	public BTNode<E> raiz;
	
	public BinaryTree() {
		raiz = null;
	}
	public void inserir(Integer valor) {
		inserir(valor,raiz);
	}
	// insere um nó raiz na árvore vazia
	private BTNode<E> inserirRaiz(Integer valor) {
		if (raiz != null)
			throw new IllegalStateException("A árvore já tem raiz");
		raiz = new BTNode<E>(valor, null, null, null);
		return raiz;
	}
	
	// insere um filho à esquerda do dado pai
	private  BTNode<E> inserirEsq(BTNode<E> pai, Integer valor) {
		if (pai.esq != null)
			throw new IllegalStateException("Este nó já tem filho à esquerda");
		BTNode<E> aux = new BTNode<E>(valor, pai, null, null);
		pai.esq = aux;
		return aux;
	}

	// insere um filho à esquerda do dado pai
	private  BTNode<E> inserirDir(BTNode<E> pai, Integer valor) {
		if (pai.dir != null)
			throw new IllegalStateException("Este nó já tem filho à direita");
		BTNode<E> aux = new BTNode<E>(valor, pai, null, null);
		pai.dir = aux;
		return aux;
	}
	private void inserir(Integer var,BTNode<E> no) {
		if(verificar(var))
			System.out.println("Valor ja existe");
		else {
			if (no==null) {
				inserirRaiz(var);
				System.out.println("Raiz: "+var);
			}
			else {
				if(var>no.valor) {
					if(no.dir!=null)
						inserir(var,no.dir);
					else {
						inserirDir(no,var);
						System.out.println("Adicionado o valor: "+var+" a direita do nó "+no.valor);
					}
			
				}
				else {
					if(no.esq!=null)
						inserir(var,no.esq);
					else {
						inserirEsq(no,var);
						System.out.println("Adicionado o valor: "+var+" a esquerda do nó "+no.valor);
					}
						
				}
			}
		}
		
	}
	public void imprimirInterfixado() {
		imprimirInterfixado2(raiz);
	}
	
	private void imprimirInterfixado2(BTNode<E> v) {
		if (v!=null) {
			imprimirInterfixado2(v.esq);
			System.out.println(v.valor+" - Altura: "+altura(v)+" - Profundidade: "+profundidade(v));
			imprimirInterfixado2(v.dir);
		}
	}
	public void imprimirPrefixado() {
		imprimirPrefixado2(raiz);
	}
	
	private void imprimirPrefixado2(BTNode<E> v) {
		if (v!=null) {
			System.out.println("Valor: "+v.valor+" - Altura: "+altura(v)+" - Profundidade: "+profundidade(v));
			imprimirPrefixado2(v.esq);
			imprimirPrefixado2(v.dir);
		}
	}
	public void imprimirPosfixado() {
		imprimirPosfixado2(raiz);
	}
	
	private void imprimirPosfixado2(BTNode<E> v) {
		if (v!=null) {
			imprimirPosfixado2(v.esq);
			imprimirPosfixado2(v.dir);
			System.out.println(v.valor+" - Altura: "+altura(v)+" - Profundidade: "+profundidade(v));
		}
	}
	public int altura(BTNode<E> no) {
		return altura1(no)-1;
	}
	private int altura1(BTNode<E> no) {
		if(no == null)
		       return 0;
		else {
		   	if (altura1(no.esq) > altura1(no.dir))
		   	   return ( 1 + altura1(no.esq) );
		   	else
			   return ( 1 + altura1(no.dir) );
		}
	}
	public void ultimo() {
		ultimo(raiz);
	}
	private void ultimo(BTNode<E> no ) {
		if(no!=null&&(no.dir==null&&no.esq==null)) {
			cont++;
			if(cont==altura(raiz)+1)		
				System.out.println(no.valor);
		}
		else if(no!=null){
			ultimo(no.esq);
			ultimo(no.dir);
		}
	}
	public int profundidade(BTNode<E> no) {
		int prof = profundidade1(no);
		
		if(prof == -1) {
			System.out.println("Nó não existe");
			return 0;
		}
		else
			return prof;
		
	}
	private int profundidade1(BTNode<E> no) {
		if(no==raiz)
			return 0;
		else if(no==null||no.valor==null)
			return -1;
		else
			return 1+profundidade(no.pai);
	}
	private boolean verificar(int valor) {
		Integer[] valores = new Integer[1000]; 
		BTNode<E> aux = raiz;
		int cotn=0;
		while(aux!=null) {
			if(aux.valor==valor)
				return true;
			if(aux.valor>valor)
				aux=aux.esq;
			else
				aux = aux.dir;
		}
		return false;
	}
	public BTNode remove(BTNode no, int num) {
		BTNode p, q;
        if (no.valor == num) {
        	if(no.esq == null){
        		return no.dir;
        	}
        	p = no;
        	q = no.esq;
        	while(q.dir != null){
        		p = q;
        		q = q.dir;
        	}
        	if(p != no){
        		p.dir = q.esq;
        		q.esq = no.esq;
        	}
        	q.dir = no.dir;
        	return q;
        } 
        else if (no.valor < num) {
            no.dir = remove(no.dir, num);
        } 
        else {
            no.esq = remove(no.esq, num);
        }
        return no; 
	}
	public void isInternal(BTNode no) {
		if(no.esq!=null&&no.dir!=null)
			System.out.println("É um nó Interno");
		else
			System.out.println("Não é um nó Interno");
	}
	public void isExternal(BTNode no) {
		if(no.esq==null&&no.dir==null)
			System.out.println("É um nó Externo");
		else
			System.out.println("Não é um nó Externo");
	}
	public BTNode remove2(BTNode no, int valor) {
		if(no==null)
			return null;
		else if(no.valor>valor) 
			no.esq = remove2(no.esq,valor);
		else if(no.valor<valor)
			no.dir = remove2(no.dir,valor);
		else {//Achou o valor
			if(no.esq==null&&no.dir==null)//Quando é folha 
				no=null;
			else if(no.esq==null) {//So tem filho na direita
				BTNode novo = no;
				no=no.dir;
				no.pai =novo.pai;
			}
			else if(no.dir == null) {//So tem filho na esquerda
				BTNode novo = no;
				no=no.esq;
				no.pai =novo.pai;
			}
			else {//Tem os dois filhos
				BTNode novo = no.esq;
				while(novo.dir!=null) {
					novo=novo.dir;
				}
				no.valor=novo.valor;
				novo.valor=valor;
				no.esq=remove2(no.esq,valor);
			}
		}
		return no;
	}
	private void antecessor(BTNode no, BTNode esq){
        if (esq.dir != null)
        {
                antecessor(no ,esq.dir);
        }
        no.valor=esq.valor;
        no = esq;
        esq = esq.esq;
        no.pai=null;
	}
	
}
