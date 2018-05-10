package memoriaCache;
//Essa classe converte de Hexa par Binario(Tudo em String)
public class HexBin {
	public static String converter(String x) {
		String r="";
		for (int i = 0; i < x.length(); i++) {
			switch(x.charAt(i)) {
			case '0':
				r+="0000";
				break;
			case '1':
				r+="0001";
				break;
			case '2':
				r+="0010";
				break;
			case '3':
				r+="0011";
				break;
			case '4':
				r+="0100";
				break;
			case '5':
				r+="0101";
				break;
			case '6':
				r+="0110";
				break;
			case '7':
				r+="0111";
				break;
			case '8':
				r+="1000";
				break;
			case '9':
				r+="1001";
				break;
			case 'a':
				r+="1010";
				break;
			case 'b':
				r+="1011";
				break;
			case 'c':
				r+="1100";
				break;
			case 'd':
				r+="1101";
				break;
			case 'e':
				r+="1110";
				break;
			case 'f':
				r+="1111";
				break;
			}
		}
		return r;
	}
}
