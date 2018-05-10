package projetoFinal;

public class Funcionario {
	private String nomeF;
	private String tipo;
	private String senha;
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNomeF() {
		return nomeF;
	}
	public Funcionario(String nomeF,String senha) {
		if(this instanceof Gerente) {
			this.tipo="Gerente";
		}
		else {
			this.tipo="Caixa";
		}
		this.nomeF = nomeF;
		this.senha = senha;
	}

	public void setNomeF(String nomeF) {
		this.nomeF = nomeF;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
