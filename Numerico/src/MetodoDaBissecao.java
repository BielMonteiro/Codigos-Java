public class MetodoDaBissecao {
	public static void metodoBissecao(double a,double b,double e) {
		//op vai fazer a comparação se for true o f(A) é maior que o f(B), com isso na hora de 
		//receber a media vai saber pra qual dos dois vai o valor
		boolean op;
		//Faz-se a comparação para setar o valor no op
		if(((a*a*a)-(9*a)+5)>((b*b*b)-(9*b)+5)) {
			op=true;
		}
		else {
			op=false;
		}
		//xk é a media de a e b
		double xk;
		//Y sera o valor testado e mudado ate ser menor que o erro
		double Y;
		int cont=1;
		while(true) {
			xk=(a+b)/2;
			Y=((xk*xk*xk)-(9*xk)+5);
			System.out.println("A"+cont+": "+a+" B"+cont+": "+b+" MD"+cont+": "+xk+" f(x"+cont+"):"+Y);
			System.out.println("-------------------------------------------------------------");
			if(op) {
				if(Y>0)
					a=xk;
				else
					b=xk;
			}
			else{
				if(Y>0)
					b=xk;
				else
					a=xk;
			}
			//Aqui pega o modulo de Y para saber se fica menor que o erro
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
