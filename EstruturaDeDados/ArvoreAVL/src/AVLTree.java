

public class AVLTree {
	static int cont=0;
    public No raiz;


    public void insere(int valor) {
        No novoNo = new No(valor);
        inserirAVL(this.raiz, novoNo);
    }

    private void inserirAVL(No noAux, No noNovo) {
    	
        if (noAux == null) {
            this.raiz = noNovo;

        } else {

            if (noNovo.getValor() > noAux.getValor()) {
            	if (noAux.getDireita() == null) {
                    noAux.setDireita(noNovo);
                    noNovo.setPai(noAux);
                    verificarBalanceamento(noAux);
                    System.out.println("Adicionado o valor: "+noNovo.getValor()+" a direita do nó "+noAux.getValor());

                } else {
                    inserirAVL(noAux.getDireita(), noNovo);
                }
                
            } else if (noNovo.getValor() < noAux.getValor()) {
                if (noAux.getEsquerda() == null) {
                    noAux.setEsquerda(noNovo);
                    noNovo.setPai(noAux);
                    verificarBalanceamento(noAux);
                    System.out.println("Adicionado o valor: "+noNovo.getValor()+" a esquerda do nó "+noAux.getValor());


                } else {
                    inserirAVL(noAux.getEsquerda(), noNovo);
                }


            } else {
                System.out.println("O nó já existe!");
            }
        }
    }

    public void verificarBalanceamento(No NoAtual) {
        indiceB(NoAtual);
        int balanceamento = NoAtual.getBalanceamento();
        if (balanceamento == -2) {

            if (altura(NoAtual.getEsquerda().getEsquerda()) >= altura(NoAtual.getEsquerda().getDireita())) {
                //LL → caso Left-Left (rotação a direita)
                NoAtual = rotacaoDireita(NoAtual);

            } else {
                //LR → caso Left-Right (rotação esquerda-direita)
                NoAtual = duplaRotacaoEsquerdaDireita(NoAtual);
            }
        } else if (balanceamento == 2) {
            if (altura(NoAtual.getDireita().getDireita()) >= altura(NoAtual.getDireita().getEsquerda())) {
                //RR → caso Right-Right (rotação a esquerda)
                NoAtual = rotacaoEsquerda(NoAtual);

            } else {
                //RL → caso Right-Left (rotação direita-esquerda)
                NoAtual = duplaRotacaoDireitaEsquerda(NoAtual);
            }
        }

        if (NoAtual.getPai() != null) {
            verificarBalanceamento(NoAtual.getPai());
        } else {
            this.raiz = NoAtual;
        }
    }
    private void indiceB(No no) {
        no.setBalanceamento((altura(no.getDireita()) - altura(no.getEsquerda())));
    
    }
    //RR → caso Right-Right (rotação a esquerda)
    public No rotacaoEsquerda(No inicial) {

        No direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        indiceB(inicial);
        indiceB(direita);

        return direita;
    }

    //LL → caso Left-Left (rotação a direita)
    public No rotacaoDireita(No inicial) {

        No esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        indiceB(inicial);
        indiceB(esquerda);

        return esquerda;
    }

    //LR → caso Left-Right (rotação esquerda-direita)
    public No duplaRotacaoEsquerdaDireita(No inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    //RL → caso Right-Left (rotação direita-esquerda)
    public No duplaRotacaoDireitaEsquerda(No inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public int altura(No no) {
		return altura1(no);
	}
	private int altura1(No no) {
		if(no == null)
		       return -1;
		else {
		   	if (altura1(no.getEsquerda()) > altura1(no.getDireita()))
		   	   return ( 1 + altura1(no.getEsquerda()) );
		   	else
			   return ( 1 + altura1(no.getDireita()) );
		}
	}
    public void imprimirInterfixado() {
        imprimirInterfixado2(raiz);
    }

    private void imprimirInterfixado2(No v) {
        if (v!=null) {
            imprimirInterfixado2(v.getEsquerda());
            System.out.println(v.getValor() + " Altura: "+altura(v)+" - Profundidade: "+profundidade(v)+ " - IndiceBalanceamento: "+v.getBalanceamento()*-1);
            imprimirInterfixado2(v.getDireita());
        }
    }
    public void imprimirPrefixado() {
		imprimirPrefixado2(raiz);
	}
	
	private void imprimirPrefixado2(No v) {
		if (v!=null) {
			System.out.println(v.getValor()+ " - IndiceBalanceamento: "+v.getBalanceamento()*-1);
			imprimirPrefixado2(v.getEsquerda());
			imprimirPrefixado2(v.getDireita());
		}
	}
	public void imprimirPosfixado() {
		imprimirPosfixado2(raiz);
	}
	
	private void imprimirPosfixado2(No v) {
		if (v!=null) {
			imprimirPosfixado2(v.getEsquerda());
			imprimirPosfixado2(v.getDireita());
			System.out.println(v.getValor() + " Altura: "+altura(v)+" - Profundidade: "+profundidade(v)+ " - IndiceBalanceamento: "+v.getBalanceamento()*-1);
		}
	}
	
	public void isInternal(No no) {
		if(no.getEsquerda()!=null&&no.getDireita()!=null)
			System.out.println("É um nó Interno");
		else
			System.out.println("Não é um nó Interno");
	}
	public void isExternal(No no) {
		if(no.getEsquerda()==null&&no.getDireita()==null)
			System.out.println("É um nó Externo");
		else
			System.out.println("Não é um nó Externo");
	}
	public void ultimo() {
		ultimo(raiz);
	}
	private void ultimo(No no ) {
		if(no!=null&&(no.getDireita()==null&&no.getEsquerda()==null)) {
			cont++;
			if(cont==altura(raiz)+1)		
				System.out.println(no.getValor());
		}
		else if(no!=null){
			ultimo(no.getEsquerda());
			ultimo(no.getDireita());
		}
	}
	public int profundidade(No no) {
		int prof = profundidade1(no);
		
		if(prof == -1) {
			System.out.println("Nó não existe");
			return 0;
		}
		else
			return prof;
		
	}
	private int profundidade1(No no) {
		if(no==raiz)
			return 0;
		else if(no==null||no.getValor()==null)
			return -1;
		else
			return 1+profundidade(no.getPai());
	}
	private void antecessor(No no, No esq){
        if (esq.getDireita() != null)
        {
                antecessor(no ,esq.getDireita());
        }
        no.setValor(esq.getValor());;
        no = esq;
        esq = esq.getEsquerda();
        no.setPai(null);
	}
	public void removerNo(Integer valor) {
		No no = buscarNo(valor);
	    No aux;
	    if(no == null){
	       return;
	    }  
	    //Remover raiz
		if (no.getEsquerda() == null || no.getDireita() == null) {
		    if (no.getPai() == null) {
		        this.raiz = null;
		        return;
		    }
		    aux = no;
		} //remover no folha
		else {
	    aux = buscarSubstituto(no);
	    no.setValor(aux.getValor());
		}
		No aux2;
		if (aux.getEsquerda() != null) 
		    aux2 = aux.getEsquerda();
		else 
		    aux2 = aux.getDireita();
		if (aux2 != null) 
		    aux2.setPai(aux.getPai());
		if (aux.getPai() == null) 
		    this.raiz = aux2;
		else {
		    if (aux == aux.getPai().getEsquerda()) {
		        aux.getPai().setEsquerda(aux2);
		    } else {
		        aux.getPai().setDireita(aux2);
		    }
		    verificarBalanceamento(aux.getPai());
		}
		aux=null;
	}
	private No buscarSubstituto(No no){
        No aux = no;
        if(no.getEsquerda() != null){
            aux= no.getEsquerda();
            while(aux.getEsquerda() != null){
                aux=aux.getDireita();
            }
        }else if(no.getDireita() != null){
            aux= no.getDireita();
            while(aux.getEsquerda() != null){
                aux=aux.getEsquerda();
            }
        }
        if (aux==raiz){
            return null;
        }
        return aux;
         
    }
    private No buscarNo(Integer valor){
        if(raiz == null){
            return null;
        }
        No aux=raiz;
        while(aux!= null && valor != aux.getValor()){
            if(valor > aux.getValor()){
                aux=aux.getDireita();
            }else{
                aux=aux.getEsquerda();
            }
        }
        if(aux == null){
            System.out.println("No não existe");
            return null;
        }
        return aux;
    } 
	/*
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
	public No remove(No no, int valor) {
		if(no==null)
			return null;
		else if(no.getValor()>valor) 
			no.setEsquerda(remove(no.getEsquerda(),valor));
		else if(no.getValor()<valor)
			no.setDireita(remove(no.getDireita(),valor));
		else {//Achou o valor
			if(no.getEsquerda()==null&&no.getDireita()==null)//Quando é folha 
				no=null;
			else if(no.getEsquerda()==null) {//So tem filho na direita
				No novo = no;
				no=no.getDireita();
				no.setPai(novo.getPai());
			}
			else if(no.getDireita() == null) {//So tem filho na esquerda
				No novo = no;
				no=no.getEsquerda();
				no.setPai(novo.getPai());
			}
			else {//Tem os dois filhos
				No novo = no.getEsquerda();
				while(novo.getDireita()!=null) {
					novo=novo.getDireita();
				}
				no.setValor(novo.getValor());
				novo.setValor(valor);
				no.setEsquerda(remove(no.getEsquerda(),valor));
			}
		}
		return no;
	}
	 */
}