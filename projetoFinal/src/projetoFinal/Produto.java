package projetoFinal;

public class Produto {
	private String nomeP;
	private double preco;
	private int id;
	private int quant;
	public Produto(String nomeP, double preco, int id, int quant){
	this.nomeP=nomeP;
	this.preco=preco;
	this.id = id;
	this.quant=quant;
	
	}
	public void listar() {
		System.out.println("º produto: "+this.nomeP);
		System.out.println("preço do produto: "+this.preco);
		System.out.println("Número de identificação: "+this.id);
		System.out.println("Quantidade desse produto no estoque: "+this.quant);
	}
	public String getNomeP() {
		return nomeP;
	}
	public void setNomeP(String nomeP) {
		this.nomeP = nomeP;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	
}
