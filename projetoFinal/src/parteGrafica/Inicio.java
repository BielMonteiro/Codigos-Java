package parteGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import projetoFinal.Caixa;
import projetoFinal.Funcionario;
import projetoFinal.Gerente;

import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Inicio extends JFrame {
	private Funcionario[] funcionario = new Funcionario[3];
	private JPanel contentPane;

	public Inicio() {
		funcionario[0] = new Gerente("Gabriel","1010");
		funcionario[1] = new Caixa("Joao","123");
		funcionario[2] = new Caixa("Carlos","321");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botaoEstoque = new JButton("Iniciar venda");
		botaoEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ii=0;
				while(ii==0) {
					String n = JOptionPane.showInputDialog("Digite Seu nome");
					String s = JOptionPane.showInputDialog("Digite Sua senha");
					if((n.equals(funcionario[1].getNomeF())&&s.equals(funcionario[1].getSenha()))||(n.equals(funcionario[2].getNomeF())&&s.equals(funcionario[2].getSenha()))) {
						ii=1;
						dispose();
						Interface frame = null;
						try {
							frame = new Interface();
						} catch (NumberFormatException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						frame.setVisible(true);
					}
				}
			}
		});
		botaoEstoque.setBounds(160, 168, 119, 23);
		contentPane.add(botaoEstoque);
		
		JButton btnCadastroDeEstoque = new JButton("Cadastro de estoque");
		btnCadastroDeEstoque.setBackground(SystemColor.activeCaption);
		btnCadastroDeEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ii=0;
				while(ii==0) {
					String n = JOptionPane.showInputDialog("Digite Seu nome");
					String s = JOptionPane.showInputDialog("Digite Sua senha");
					if(n.equals(funcionario[0].getNomeF())&&s.equals(funcionario[0].getSenha())) {
						ii=1;
						dispose();
						Estoque frame = null;
						try {
							frame = new Estoque();
						} catch (NumberFormatException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"Nome do gerente ou senha errados.");
					}
				}
			}
			
		});
		btnCadastroDeEstoque.setBounds(130, 202, 174, 48);
		contentPane.add(btnCadastroDeEstoque);
	}
}
