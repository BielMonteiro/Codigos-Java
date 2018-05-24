public class MetodoDaBissecao {
	public static void metodoBissecao(double a,double b,double e) {
		double xk;
		double Y;
		int cont=0;
		while(true) {
			xk=(a+b)/2;
			Y=(xk*xk)-(5*xk)+6;
			System.out.println("A"+cont+": "+a+" B"+cont+": "+b+" MD"+cont+": "+xk+" f(x"+cont+"):"+Y);
			System.out.println("-------------------------------------------------------------");
			if(Y>0)
				a=xk;
			else
				b=xk;
			if(Y<0) {
				Y*=-1;
			}
			if(Y<e) {
				System.out.println("A função converge para o ponto: "+xk+". E precisou de "+cont+" interações");
				break;
			}
			cont++;
		}
	}
}
