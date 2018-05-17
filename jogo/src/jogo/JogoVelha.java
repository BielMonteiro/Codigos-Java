package jogo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
public class JogoVelha extends JFrame {
	JButton btn00 = new JButton("");
	JButton btn01 = new JButton("");
	JButton btn02 = new JButton("");
	JButton btn10 = new JButton("");
	JButton btn11 = new JButton("");
	JButton btn12 = new JButton("");
	JButton btn20 = new JButton("");
	JButton btn21 = new JButton("");
	JButton btn22 = new JButton("");
	JLabel lblNome = new JLabel("Jogador 1");
	private JPanel contentPane;
	int cont=1;
	static int valor1=0;
	static int valor2=0;
	static int emp=0;
	String[][] mat = new String[3][3];
	private final JLabel lblEmpates = new JLabel("Numero de Empates: ");
	private final JLabel label = new JLabel("-------------------------------------------");
	public JogoVelha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btn00.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn00.setBounds(36, 38, 60, 42);
		contentPane.add(btn00);
		btn01.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn01.setBounds(108, 38, 60, 42);
		contentPane.add(btn01);
		btn02.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn02.setBounds(180, 38, 60, 42);
		contentPane.add(btn02);
		btn10.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn10.setBounds(36, 92, 60, 42);
		contentPane.add(btn10);
		btn11.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn11.setBounds(108, 92, 60, 42);
		contentPane.add(btn11);
		btn12.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn12.setBounds(180, 92, 60, 42);
		contentPane.add(btn12);
		btn20.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn20.setBounds(36, 148, 60, 42);
		contentPane.add(btn20);
		btn21.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn21.setBounds(108, 148, 60, 42);
		contentPane.add(btn21);
		btn22.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn22.setBounds(180, 148, 60, 42);
		contentPane.add(btn22);
		
		lblNome.setBounds(26, 12, 70, 15);
		contentPane.add(lblNome);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				JogoVelha frame = new JogoVelha();
				frame.setVisible(true);
			}
		});
		btnReiniciar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnReiniciar.setBounds(335, 227, 89, 23);
		contentPane.add(btnReiniciar);
		
		JLabel lblJogador1 = new JLabel("Jogador 1(X):");
		lblJogador1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblJogador1.setBounds(269, 83, 101, 14);
		contentPane.add(lblJogador1);
		
		JLabel lblJogador2 = new JLabel("Jogador 2(O):");
		lblJogador2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblJogador2.setBounds(269, 108, 101, 14);
		contentPane.add(lblJogador2);
		
		JLabel lblInfoJogo = new JLabel("Informacoes do Jogo");
		lblInfoJogo.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblInfoJogo.setBounds(268, 38, 144, 14);
		contentPane.add(lblInfoJogo);
		
		JLabel lblVitorias_1 = new JLabel("Vitorias");
		lblVitorias_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblVitorias_1.setBounds(295, 63, 63, 14);
		contentPane.add(lblVitorias_1);
		lblEmpates.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblEmpates.setBounds(269, 147, 155, 14);
		
		contentPane.add(lblEmpates);
		label.setBounds(250, 133, 174, 7);
		
		contentPane.add(label);
		lblJogador1.setText("Jogador 1(X): "+valor1);
		lblJogador2.setText("Jogador 2(O): "+valor2);
		lblEmpates.setText("Numero de Empates: "+emp);
		btn00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn00.getText()=="") {
					if(cont%2!=0) {
						btn00.setText("X");
					}
					else {
						btn00.setText("O");
					}
				}
				btn00.setEnabled(false);
				result();
			}
		});
		
		btn01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn01.getText()=="") {
					if(cont%2!=0) {
						btn01.setText("X");
					}
					else {
						btn01.setText("O");
					}	
				}
				btn01.setEnabled(false);
				result();
			}
		});
		btn02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn02.getText()=="") {
					if(cont%2!=0) {
						btn02.setText("X");
					}
					else {
						btn02.setText("O");
					}	
				}
				btn02.setEnabled(false);
				result();
			}
		});
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn10.getText()=="") {
					if(cont%2!=0) {
						btn10.setText("X");
					}
					else {
						btn10.setText("O");
					}	
				}
				btn10.setEnabled(false);
				result();
			}
		});
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn11.getText()=="") {
					if(cont%2!=0) {
						btn11.setText("X");
					}
					else {
						btn11.setText("O");
					}	
				}
				btn11.setEnabled(false);
				result();
			}
		});
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn12.getText()=="") {
					if(cont%2!=0) {
						btn12.setText("X");
					}
					else
						btn12.setText("O");
				}
				btn12.setEnabled(false);
				result();
			}
		});
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn20.getText()=="") {
					if(cont%2!=0) {
						btn20.setText("X");
					}
					else
						btn20.setText("O");
				}
				btn20.setEnabled(false);
				result();
			}
		});
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn21.getText()=="") {
					if(cont%2!=0) {
						btn21.setText("X");
					}
					else
						btn21.setText("O");
				}
				btn21.setEnabled(false);
				result();
			}
		});
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn22.getText()=="") {
					if(cont%2!=0) {
						btn22.setText("X");
					}
					else
						btn22.setText("O");
				}
				btn22.setEnabled(false);
				result();
			}
		});
	}
	public void result() {
		int b=0;
		if((!btn00.getText().equals("")&&btn00.getText().equals(btn01.getText())&& (btn01.getText().equals(btn02.getText())))) {
			btn00.setBackground(Color.GREEN);
			btn01.setBackground(Color.GREEN);
			btn02.setBackground(Color.GREEN);
		}
		else if((!btn10.getText().equals("")&&btn10.getText().equals(btn11.getText())&& (btn11.getText().equals(btn12.getText())))) {
			btn10.setBackground(Color.GREEN);
			btn11.setBackground(Color.GREEN);
			btn12.setBackground(Color.GREEN);
		}
		else if((!btn20.getText().equals("")&&btn20.getText().equals(btn21.getText())&& (btn21.getText().equals(btn22.getText())))) {
			btn20.setBackground(Color.GREEN);
			btn21.setBackground(Color.GREEN);
			btn22.setBackground(Color.GREEN);
		}
		else if((!btn00.getText().equals("")&&btn00.getText().equals(btn10.getText())&& (btn10.getText().equals(btn20.getText())))) {
			btn00.setBackground(Color.GREEN);
			btn10.setBackground(Color.GREEN);
			btn20.setBackground(Color.GREEN);
		}
		else if((!btn01.getText().equals("")&&btn01.getText().equals(btn11.getText())&& (btn11.getText().equals(btn21.getText())))) {
			btn01.setBackground(Color.GREEN);
			btn11.setBackground(Color.GREEN);
			btn21.setBackground(Color.GREEN);
		}
		else if((!btn02.getText().equals("")&&btn02.getText().equals(btn12.getText())&& (btn12.getText().equals(btn22.getText())))) {
			btn02.setBackground(Color.GREEN);
			btn12.setBackground(Color.GREEN);
			btn22.setBackground(Color.GREEN);
		}
		else if((!btn00.getText().equals("")&&btn00.getText().equals(btn11.getText())&& (btn11.getText().equals(btn22.getText())))) {
			btn00.setBackground(Color.GREEN);
			btn11.setBackground(Color.GREEN);
			btn22.setBackground(Color.GREEN);
		}
		else if((!btn02.getText().equals("")&&btn02.getText().equals(btn11.getText())&& (btn11.getText().equals(btn20.getText())))) {
			btn02.setBackground(Color.GREEN);
			btn11.setBackground(Color.GREEN);
			btn20.setBackground(Color.GREEN);
		}
		if(btn00.getBackground().equals(Color.green)||btn11.getBackground().equals(Color.green)||btn22.getBackground().equals(Color.green)) {
			if(lblNome.getText().equals("Jogador 1")) {
				 JOptionPane.showMessageDialog(null,"O 1° Jogador ganhou");
				 valor1++;
			}
			else if(lblNome.getText().equals("Jogador 2")) {
				JOptionPane.showMessageDialog(null,"O 2° Jogador ganhou");
				valor2++;
			}
			b=1;
		}
		if(b==0) {
			cont++;
			if(cont%2==1)
				lblNome.setText("Jogador 1");
			else
				lblNome.setText("Jogador 2");
		}
		if(b==0 && cont==10) {
			JOptionPane.showMessageDialog(null,"Deu velha");
			emp++;
		}
	}
}