package memoriaCache;
import java.io.*;
import java.util.Scanner;

public class Teste {
	public static void main(String args[]) throws IOException  {
		File file = new File("trace");
		TesteCache cache = new TesteCache(file,16384,8,"Lru");
		cache.resultado();
		/*Aqui eu est�ncio a classe TesteCache que nela ocorrer� junto com a HexBin o simulador de memoria cache
		 Passo os parametros que v�o ser jogados no construtor da TesteCache e logo chamo o metodo responsavel*/ 

	}
}
