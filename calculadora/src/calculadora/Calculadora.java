package calculadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class Calculadora extends JFrame {
	private double num1,num2,result,valor;
	private String tipo;
	private JPanel contentPane;
	private JTextField tela;
	private JButton botao7;
	private JButton botao8;
	private JButton botao9;
	private JButton botao4;
	private JButton botao5;
	private JButton botao6;
	private JButton botao1;
	private JButton botao2;
	private JButton botao3;
	private JButton botaoCe;
	private JButton botao0;
	private JButton botaoMais;
	private JButton botaoMenos;
	private JButton botaoDividir;
	private JButton botaoMultiplicar;
	private JButton botaoResultado;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setResizable(false);
		setTitle("Calculadora");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 242, 322);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tela = new JTextField();
		tela.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tela.setEditable(false);
		tela.setForeground(SystemColor.desktop);
		tela.setBackground(SystemColor.text);
		tela.setColumns(10);
		
		botao1 = new JButton("1");
		botao1.setBackground(SystemColor.text);
		botao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"1");
				valor=Integer.parseInt(tela.getText());
			}
		});
		
		botao2 = new JButton("2");
		botao2.setBackground(SystemColor.text);
		botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"2");
				valor=Integer.parseInt(tela.getText());
			}
		});
		
		botao3 = new JButton("3");
		botao3.setBackground(SystemColor.text);
		botao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"3");
				valor=Integer.parseInt(tela.getText());
			}
		});
		botao4 = new JButton("4");
		botao4.setBackground(SystemColor.text);
		botao4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"4");
				valor=Integer.parseInt(tela.getText());
			}
		});
		
		botao5 = new JButton("5");
		botao5.setBackground(SystemColor.text);
		botao5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"5");
				valor=Integer.parseInt(tela.getText());
			}
		});
		
		botao6 = new JButton("6");
		botao6.setBackground(SystemColor.text);
		botao6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"6");
				valor=Integer.parseInt(tela.getText());
			}
		});
		botao7 = new JButton("7");
		botao7.setBackground(SystemColor.text);
		botao7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"7");
				valor=Integer.parseInt(tela.getText());
			}
		});
		botao8 = new JButton("8");
		botao8.setBackground(SystemColor.text);
		botao8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"8");
				valor=Integer.parseInt(tela.getText());
			}
		});
		
		botao9 = new JButton("9");
		botao9.setBackground(SystemColor.text);
		botao9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"9");
				valor=Integer.parseInt(tela.getText());
			}
		});
		
		botaoCe = new JButton("C");
		botaoCe.setBackground(SystemColor.control);
		botaoCe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valor=0;
				num1=0;
				tela.setText(null);
			}
		});
		
		botao0 = new JButton("0");
		botao0.setBackground(SystemColor.text);
		botao0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(tela.getText()+"0");
				valor=Integer.parseInt(tela.getText());
			}
		});
		
		botaoMais = new JButton("+");
		botaoMais.setBackground(SystemColor.control);
		botaoMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(null);
				tipo="soma";
				num1=valor;
			}
		});
		
		botaoMenos = new JButton("-");
		botaoMenos.setBackground(SystemColor.control);
		botaoMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(null);
				tipo="sub";
				num1=valor;
			}
		});
		
		botaoDividir = new JButton("/");
		botaoDividir.setBackground(SystemColor.control);
		botaoDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(null);
				tipo="div";
				num1=valor;
			}
		});
		
		botaoMultiplicar = new JButton("*");
		botaoMultiplicar.setBackground(SystemColor.control);
		botaoMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tela.setText(null);
				tipo="mult";
				num1=valor;
			}
			
		});
		
		botaoResultado = new JButton("=");
		botaoResultado.setBackground(SystemColor.control);
		botaoResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(tipo){
				case "soma":
					result = num1+valor;
					break;
				case "sub":
					result = num1-valor;
					break;
				case "mult":
					result = num1*valor;
					break;
				case "div":
					result = num1/valor;
					break;
				}
				tela.setText(String.valueOf(result));
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tela, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(botao4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botao5, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botao6, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botaoMenos, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(botao7, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botao8, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botao9, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(botaoMais, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(botaoCe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(botao1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(botao0, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
								.addComponent(botao2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(botao3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(botaoResultado, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(botaoDividir, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(botaoMultiplicar, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(tela, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(botao7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(botao8, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(botao9, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoMais, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(botao4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(botao5, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(botao6, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addComponent(botaoMenos, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(botao1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(botao2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(botao3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(botaoDividir, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(botaoCe, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(botao0, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(botaoMultiplicar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(botaoResultado, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
