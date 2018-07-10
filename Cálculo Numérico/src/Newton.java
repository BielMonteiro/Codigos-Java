
public class Newton {
	
	public static void main(String[] args) {
		
		System.out.printf("\nMÉTODO DE NEWTON\n");
		
		newton(1, 0.01);
		
	}
	
	/*
	 * Math.sin(x)
	 * Math.cos(x)
	 * 
	 * Math.sqrt(x)
	 * Math.pow(x, x)
	 * Math.abs(resultado)
	 * 
	 * Math.E
	 * Math.PI
	 * 
	 * */
	
	public static double funcao(double x) {
		return Math.pow(x, 3) - 5*Math.pow(x, 2) + 1.75*x + 6;
	}
	
	public static double derivada(double x) {
		return 3*Math.pow(x, 2) - 10*x + 1.75;
	}
	
	public static void newton(double x, double erro) {
		int k = 1;
		double newX = 0;
		double erroAtual = 1;
		while(erroAtual > erro) {
			System.out.printf("X%d: Xk: %.5f - f(x): %.5f - f'(x): %.5f", k, x, funcao(x), derivada(x));
			newX = x - ( funcao(x) / derivada(x) );
			System.out.printf(" - Xk+1: %.5f - ", newX);
			erroAtual = erro(x, newX);
			x = newX;
			k++;
		}
		System.out.println("Converge para: " + newX);
	}
	
	public static double erro(double x, double newX) { // Erro Relativo
		double erro = Math.abs(newX - x) / Math.abs(newX);
		System.out.printf("Erro: %.5f\n\n", erro);
		return erro;
	}
}
