package ListaSite;

public class ListaEncadeadaSite{
	
	private NoSite cabeca;
	private int tamanho;
	
	public ListaEncadeadaSite() {
		cabeca = null;
		tamanho =0;
	}
	public String insereFim(String site,String linkSite) {
		if(listaVazia(site,linkSite)==true)
			return site;
		getCauda().setProximo(new NoSite(site,linkSite,null));
		tamanho++;
		return site;
	}
	public String inserePosicao(String site,String linkSite,int posicao) {
		NoSite aux = cabeca;
		if(listaVazia(site,linkSite)==true)
			return site;
		if(posicao==1)
			insereInicio(site,linkSite);
		else if(posicao==tamanho+1)
			insereFim(site,linkSite);
		else if(posicao<=0 || posicao>tamanho)
			System.out.println("Posição não existe");
		else {
			for (int i = 0; i <posicao-2; i++) {
				aux=aux.getProximo();
			}
			NoSite aux2=aux;
			aux2.setProximo(new NoSite(site,linkSite,aux.getProximo()));
			tamanho++;
		}
		return aux.getSite();
	}
	public String insereInicio(String site, String linkSite) {
		if(listaVazia(site,linkSite)==true)
			return site;
		NoSite aux=cabeca;
		cabeca=new NoSite(site,linkSite,null);
		cabeca.setProximo(aux);
		tamanho++;
		return site;
	}
	public String removeFim() {
		NoSite aux = cabeca;
		if(getCauda()==null) {
			System.out.println("Não existe elementos para remover.");
			return null;
		}
		getPenultimo().setProximo(null);
		tamanho--;
		return aux.getSite();
		
	}
	public String removeInicio() {
		NoSite aux = cabeca;
		if(cabeca==null) {
			System.out.println("Não existe elementos para remover.");
			return null;
		}
		cabeca = cabeca.getProximo();
		tamanho--;
		return aux.getSite();
	}
	public String removePosicao(int posicao) {
		NoSite aux = cabeca;
		if(posicao==1)
			removeInicio();
		else if(posicao==tamanho)
			removeFim();
		else if(posicao<=0 || posicao>tamanho)
			System.out.println("Posição não existe");
		else {
			for (int i = 0; i <posicao-2; i++) {
				aux=aux.getProximo();
			}
			NoSite aux2=aux;
			aux2.setProximo(aux.getProximo().getProximo());
			tamanho--;
		}
		return aux.getSite();
	}
	public NoSite getPenultimo(){
		NoSite aux = cabeca;
		if(aux == null){
			return null;
		}
		while(aux.getProximo().getProximo() != null){
			aux = aux.getProximo();
		}
		return aux;
	}
	public NoSite getCauda(){
			NoSite aux = cabeca;
			if(aux == null){
				return null;
			}
			while(aux.getProximo() != null){
				aux = aux.getProximo();
			}
			return aux;
	}
	public void antepenultimo() {
		NoSite aux=cabeca;
		if(tamanho<3)
			System.out.println("Não existe antepenúltimo");
		else
			for (aux = cabeca;aux.getProximo().getProximo().getProximo()!=null;aux =aux.getProximo()) {
				
			}
		System.out.println("Esse é o antePenultimo: "+aux.getSite());
	}
	public boolean listaVazia(String site,String linkSite) {
		if(tamanho==0) {
			cabeca = new NoSite(site,linkSite,null);
			tamanho++;
			return true;
		}
		return false;
	}
	public void buscarSite(String site) {
		int i=0;
		String siteN;
		String linkS;
		NoSite nomeSite = cabeca;
		for(nomeSite=cabeca;nomeSite!=null;nomeSite=nomeSite.getProximo()) {
			i++;
			if(site.equals(nomeSite.getSite()))
				break;
		}
		siteN=nomeSite.getSite();
		linkS = nomeSite.getLinkSite();
		removePosicao(i);
		insereInicio(siteN,linkS);
	}
	public void imprimirLista() {
		NoSite aux = cabeca;
		if(cabeca==null) {
			System.out.println("Lista vazia.");
			return;
		}
		for(aux = cabeca;aux!=null;aux=aux.getProximo()) {
			System.out.print(aux.getSite()+" ");
		}
		System.out.println();
	}
	
}
