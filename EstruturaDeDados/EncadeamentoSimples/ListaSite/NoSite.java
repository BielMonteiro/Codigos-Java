package ListaSite;
public class NoSite {
	private String site;
	public String getSite() {
		return site;
	}
	public NoSite(String site,String linkSite,NoSite proximo) {
		this.site = site;
		this.proximo = proximo;
		this.linkSite=linkSite;
	}
	public void setSite(String site) {
		this.site = site;
	}

	public String getLinkSite() {
		return linkSite;
	}

	public void setLinkSite(String linkSite) {
		this.linkSite = linkSite;
	}
	private String linkSite;
	private NoSite proximo;
	
	
	public NoSite getProximo() {
		return proximo;
	}
	public void setProximo(NoSite proximo) {
		this.proximo = proximo;
	}
	
}
