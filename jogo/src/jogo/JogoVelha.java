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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class JogoVelha extends JFrame implements ActionListener{
	JButton btn00 = new JButton("");
	JButton btn01 = new JButton("");
	JButton btn02 = new JButton("");
	JButton btn10 = new JButton("");
	JButton btn11 = new JButton("");
	JButton btn12 = new JButton("");
	JButton btn20 = new JButton("");
	JButton btn21 = new JButton("");
	JButton btn22 = new JButton("");
	JButton btnNew = new JButton("");
	JLabel lblNome = new JLabel("Jogador 1");
	
	private JPanel contentPane;
	int cont=1;
	static int valor1=0;
	static int valor2=0;
	static int emp=0;
	int ganhador=0;
	static boolean jogador=true;
	
	private final JLabel lblEmpates = new JLabel("Numero de Empates: ");
	private final JLabel label = new JLabel("-------------------------------------------");
	int volta=0;
	private final JMenuItem mntmNovoJogo = new JMenuItem("Novo Jogo");
	
	public JogoVelha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 322);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpcao = new JMenu("Opcao");
		menuBar.add(mnOpcao);
		mntmNovoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor1=0;
				valor2=0;
				emp=0;
				cont=1;
				dispose();
				JogoVelha frame = new JogoVelha();
				frame.setVisible(true);
				/*
				btn00.setText("");
				btn00.setEnabled(true);
				btn01.setText("");
				btn01.setEnabled(true);
				btn02.setText("");
				btn02.setEnabled(true);
				btn10.setText("");
				btn10.setEnabled(true);
				btn11.setText("");
				btn11.setEnabled(true);
				btn12.setText("");
				btn12.setEnabled(true);
				btn20.setText("");
				btn20.setEnabled(true);
				btn21.setText("");
				btn21.setEnabled(true);
				btn22.setText("");
				btn22.setEnabled(true);*/
			}
		});
		
		mnOpcao.add(mntmNovoJogo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn00.addActionListener(this);
		btn01.addActionListener(this);
		btn02.addActionListener(this);
		btn10.addActionListener(this);
		btn11.addActionListener(this);
		btn12.addActionListener(this);
		btn20.addActionListener(this);
		btn21.addActionListener(this);
		btn22.addActionListener(this);
		
		setLocationRelativeTo(null);
		
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
		lblNome.setFont(new Font("Arial Black", Font.PLAIN, 11));
		
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
		btnReiniciar.setBounds(335, 229, 89, 23);
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
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(volta==0 && cont!=0) {
					btnNew.setText("");
					btnNew.setEnabled(true);
					cont-=2;
					result();
					volta=1;
				}
			}
		});
		btnVoltar.setBounds(41, 228, 89, 23);
		contentPane.add(btnVoltar);
		
	}
	
	public void result() {
		if(cont>4) {
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
			if((btn00.getBackground().equals(Color.green)||btn11.getBackground().equals(Color.green)||btn22.getBackground().equals(Color.green)) && ganhador==0) {
				if(lblNome.getText().equals("Jogador 1")) {
					 JOptionPane.showMessageDialog(null,"O 1� Jogador ganhou");
					 valor1++;
				}
				else if(lblNome.getText().equals("Jogador 2")) {
					JOptionPane.showMessageDialog(null,"O 2� Jogador ganhou");
					valor2++;
				}
				ganhador=1;
				cont=0;
			}
			
		}
		if(ganhador==0) {
			cont++;
			if(jogador) {
				lblNome.setText("Jogador 1");
			}
			else {
				lblNome.setText("Jogador 2");
			}
			volta=0;
		}
		if(ganhador==0 && cont==10) {
			JOptionPane.showMessageDialog(null,"Deu velha");
			emp++;
			cont=0;
			ganhador=1;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton genericButton = (JButton) e.getSource();
		btnNew=genericButton;
		if(genericButton.getText() == "" && ganhador==0) {
			if(jogador) {
				genericButton.setText("X");
			}
			else
				genericButton.setText("O");
		}
		jogador=!jogador;
		genericButton.setEnabled(false);
		result();
		
	}
}