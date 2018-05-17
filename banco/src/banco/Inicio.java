package banco;
//"Select * from tabelas" Ler a tebela; op==1
//"Update tabelas Set nome="+variavel+" Where id ="+variavel; op==2
//Insert Into tabelas(nome,idade) values('"+nome+"','"+idade+"')";Insere o elemento. op=3
//"Delete From tabelas Where nome='"+nome+"'"; Remove o elemento. op==4
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Inicio {
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
	public static void ligar() throws SQLException {
		String url = "jdbc:mysql://localhost/Banco?useSSL=false";
		conexao = DriverManager.getConnection(url,"root","");
	}
	public static void operacoes() throws NumberFormatException, SQLException {
		if(op==1) {
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
			pesquisa=conexao.prepareStatement("Update tabelas Set nome='"+nome+"' Where id ='"+id+"'");
			pesquisa.executeUpdate();
		}
		else if(op==3) {
			pesquisa=conexao.prepareStatement("Insert Into tabelas(nome,idade) values('"+nome+"','"+idade+"')");
			pesquisa.executeUpdate();
		}
		else if(op==4) {
			pesquisa=conexao.prepareStatement("Delete From tabelas Where nome='"+nome+"'");
			pesquisa.executeUpdate();
		}
		else if(op==5) {
			pesquisa=conexao.prepareStatement("Truncate tabelas");
			pesquisa.executeUpdate();
		}
	}

}
