package projetoFinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Venda {
	Produto[] produtos;
	private double valor;
	//J vai ser recebido do arquivo que tem a quantidade de produtos
	private int j;
	public Venda(Produto[] produtos) {
		this.produtos = new Produto[j];
		
		for (int i = 0; i < produtos.length; i++) {
			
		}
	}
	public void compra(int id) {
		valor += produtos[id].getPreco();
	}
	
	
}
