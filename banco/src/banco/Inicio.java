package banco;
//Comentarios Sobre os op(o tipo de operacoes) e o que cada um significa
//"Select * from tabelas" Ler a tebela; op==1
//"Update tabelas Set nome='"+variavel+"' Where id ="+'"+variavel+"'"; Muda o elemento da tabela, de acordo com o id(PK) op==2
//Insert Into tabelas(nome,idade) values('"+nome+"','"+idade+"')";Insere o elemento. op=3
//"Delete From tabelas Where nome='"+nome+"'"; Remove o elemento. op==4
//"Truncate tabelas"; Remove todos os elementos da tabela. op==5

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Inicio {
	//Todas as variaveis que usarei nas classes
	static int op;
	static String nome;
	static int idade;
	static int id;
	static String sql;
	static java.sql.PreparedStatement pesquisa;
	static Connection conexao;
	static ResultSet resultado;
	
	public static void main(String[] args) throws SQLException {

		ligar();
		op=1;
		operacoes();
		op=3;
		nome="Gabriel";
		idade=21;
		operacoes();
		op=1;
		operacoes();
		
	}
	//Aqui ela "Liga" o banco de dados, dando o nome do Banco que usaremos
	public static void ligar() throws SQLException {
		//Aqui se faz o caminho do Banco 
		String url = "jdbc:mysql://localhost/Banco?useSSL=false";
		//Aqui Cria-se uma "conexao" com o Banco de dados, dando o caminho(url),User,senha
		conexao = DriverManager.getConnection(url,"root","");
	}
	public static void operacoes() throws NumberFormatException, SQLException {
		//Aqui funciona as operações que realizaremos de acordo com a opcao selecionada
		if(op==1) {
			//Lista todos os elementos da tabela
			pesquisa=conexao.prepareStatement("Select * from tabelas");
			resultado = pesquisa.executeQuery();
			while(resultado.next()) {
				String name = resultado.getString("nome");
				String ident = resultado.getString("id");
				int idadE = Integer.parseInt(resultado.getString("idade"));
				System.out.println("Nome: "+name+" Idade: "+idadE+" Seu id: "+ident );
			}
		}
		else if(op==2) {
			//troca o valor de uma linha
			pesquisa=conexao.prepareStatement("Update tabelas Set nome='"+nome+"' Where id ='"+id+"'");
			pesquisa.executeUpdate();
		}
		else if(op==3) {
			//insere um elemento a tabela
			pesquisa=conexao.prepareStatement("Insert Into tabelas(nome,idade) values('"+nome+"','"+idade+"')");
			pesquisa.executeUpdate();
		}
		else if(op==4) {
			//elimina um elemento da tabela
			pesquisa=conexao.prepareStatement("Delete From tabelas Where nome='"+nome+"'");
			pesquisa.executeUpdate();
		}
		else if(op==5) {
			//apaga todos os elementos da tabela
			pesquisa=conexao.prepareStatement("Truncate tabelas");
			pesquisa.executeUpdate();
		}
	}

}
