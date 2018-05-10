package calculadora;

import java.awt.EventQueue;

public class CaculadoraT {
	public static void main(String[] args) {
			try {
				Calculadora frame = new Calculadora();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
