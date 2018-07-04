package FilaEncadeada;

public class No {
	private Integer valor;
	private No proximo;
	
	public No(Integer valor, No proximo) {
		this.valor = valor;
		this.proximo = proximo;
	}
	
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		valor = valor;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	
}
