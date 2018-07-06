package ListaDuplamenteEncadeada;

public class NoDuplo {
	private Integer valor;
	private NoDuplo proximo;
	private NoDuplo anterior;
	
	public NoDuplo(Integer valor, NoDuplo proximo,NoDuplo anterior) {
		this.valor = valor;
		this.proximo = proximo;
		this.anterior = anterior;
	}
	
	public Integer getValor() {
		return valor;
	}
	public NoDuplo getAnterior() {
		return anterior;
	}

	public void setAnterior(NoDuplo anterior) {
		this.anterior = anterior;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public NoDuplo getProximo() {
		return proximo;
	}
	public void setProximo(NoDuplo proximo) {
		this.proximo = proximo;
	}
	
}
