package ListaDuplamenteEncadeada;

public class No {
	private Integer valor;
	private No proximo;
	private No anterior;
	
	public No(Integer valor, No proximo,No anterior) {
		this.valor = valor;
		this.proximo = proximo;
		this.anterior = anterior;
	}
	
	public Integer getValor() {
		return valor;
	}
	public No getAnterior() {
		return anterior;
	}

	public void setAnterior(No anterior) {
		this.anterior = anterior;
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
