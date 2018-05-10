//Aqui tudo que importei
package parteGrafica;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import projetoFinal.Caixa;
import projetoFinal.Funcionario;
import projetoFinal.Gerente;
import projetoFinal.Produto;
//Inicio da classe Iterface onde vai ficar o inicio do programa
public class Interface extends JFrame {
	private int produtoRemovidos=0;
	private Funcionario[] funcionario = new Funcionario[3];
	private String[] t2;
	private String t;
	private int quant=0;
	private int[] aux=new int[50];
	private File file ;
	private static Produto[] produto = new Produto[50];
	private double valor=0;
	private JPanel contentPane;
	private JTextField campoNome;
	private JPasswordField campoSenha;
//Construtor da classe que ja vem com o throws para excecoes
	public Interface() throws IOException {
		//Instancio 3 funcionarios, 1 Gerente e 2 Caixas
		funcionario[0] = new Gerente("Gabriel","1010");
		funcionario[1] = new Caixa("Joao","123");
		funcionario[2] = new Caixa("Carlos","321");
		//instancio o Arquivo onde vai ficar guardado os produtos
		file= new File("t.txt");
		//Aqui leio Todo o arquivo e jogo num vetor de produto que ja é uma classe instanciada 
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while((this.t=br.readLine() )!= null) {
			t2=t.split(" ");
			produto[quant] = new Produto(t2[0],Double.parseDouble(t2[1]),Integer.parseInt(t2[2]),Integer.parseInt(t2[3]));
			//quant é o contador para saber quantos produtos existe
			quant++;
		}
		//Aqui deixo a janela visivel e embaixo seto alguns parametros tipo o de fechar o programa de vez e não deixar ele como segundo plano
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 476);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//Aqui são umas label que criei
		JLabel labelProduto = new JLabel("Produtos");
		
		JButton botaoAd = new JButton("Adicionar");
		//Aqui é o comboBox que vai ficar agrupado todos os produtos
		JComboBox comboBox = new JComboBox();
		for (int i = 0; i <quant; i++) {
				comboBox.addItem(produto[i].getNomeP()+"- preco: "+produto[i].getPreco()+"R$ || "+produto[i].getQuant());
		}
		//Aqui faço isso so por estetica
		comboBox.setSelectedItem(null);;
		//Aqi mais uma Label
		JLabel labelNome = new JLabel("Nome");
		
		JLabel labelSenha = new JLabel("Senha");
		//Aqui um TextField
		campoNome = new JTextField();
		campoNome.setColumns(10);
		//Aqui o evento do botao confirmar, se estiver tudo okay na compra ele decrementa do vetor de produto e atualiza no arquivo e so sai se colocar o nome e a senha correta
		JButton botaoAceitar = new JButton("Confirmar");
		botaoAceitar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				if((campoNome.getText().equals(funcionario[1].getNomeF())&&(campoSenha.getText().equals(funcionario[1].getSenha()))||(campoNome.getText().equals(funcionario[2].getNomeF())&&campoSenha.getText().equals(funcionario[2].getSenha())))){
					JOptionPane.showMessageDialog(null,"Compra efetuada com sucesso");
					dispose();
					try {
						escritor(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Problema na senha ou nome");
				}
			}
		});
		//Aqui o evento do botao cancelar, ele cancela a compra, mas so com o nome e a senha do gerente. Só vai sair quando o gerente inserir o nome e a senha correta
		JButton botaoCancelar = new JButton("Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				int ii=0;
				while(ii==0) {
					String n = JOptionPane.showInputDialog("Digite Seu nome");
					String s = JOptionPane.showInputDialog("Digite Sua senha");
					if(n.equals(funcionario[0].getNomeF())&&s.equals(funcionario[0].getSenha())) {
						ii=1;
						JOptionPane.showMessageDialog(null,"Compra cancelada");
						for (int i = 0; i < produto.length; i++) {
							if(aux[i]!=0)
								produto[i].setQuant((produto[i].getQuant()+aux[i]));
								
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Nome ou Senha incorreta");
				}
			}
		});
		
		JTextPane campoQuant = new JTextPane();
		campoQuant.setBackground(SystemColor.activeCaptionBorder);
		campoQuant.setText("1");
		//Aqui fica o campo da quantidade
		JLabel lblQuantidade = new JLabel("Quantidade");
		campoSenha = new JPasswordField();
		//Aqui fica o campo que irá mostrar o valor da compra e toda vez que adicionar um novo produto ele vai incrementar o valor(com o auxilio do botao adicionar)
		JTextPane campoTexto = new JTextPane();
		botaoAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(produto[comboBox.getSelectedIndex()].getQuant()>=Integer.parseInt(campoQuant.getText())){
					if(produto[comboBox.getSelectedIndex()].getQuant()>0) {
						campoTexto.setText("Valor da compra: \n");
						if(comboBox.getSelectedItem()!=null) {
							aux[comboBox.getSelectedIndex()]+=(1*Integer.parseInt(campoQuant.getText()));
							valor+=(produto[comboBox.getSelectedIndex()].getPreco()*Integer.parseInt(campoQuant.getText()));
							campoTexto.setText(campoTexto.getText()+String.valueOf(valor));
							produto[comboBox.getSelectedIndex()].setQuant(produto[comboBox.getSelectedIndex()].getQuant()-1*Integer.parseInt(campoQuant.getText()));
							comboBox.removeAllItems();
							System.out.println(comboBox.getSelectedIndex());
							for (int i = 0; i <quant; i++) {
									comboBox.addItem(produto[i].getNomeP()+"- preco: "+produto[i].getPreco()+"R$ || "+produto[i].getQuant());
							}
						}
						campoQuant.setText("1");
					}
					else
						JOptionPane.showMessageDialog(null,"Produto em Falta");
				}
				else
					JOptionPane.showMessageDialog(null,"Valor maior que o estoque");
			}
		});
		//Layout e Ajustes das telas
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelNome)
								.addComponent(labelSenha))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(campoSenha, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(campoNome, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.RELATED, 324, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(0, 0, Short.MAX_VALUE)
									.addComponent(labelProduto)
									.addGap(2)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(campoQuant, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addComponent(botaoAd, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuantidade)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(9)
									.addComponent(botaoAceitar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(botaoCancelar))
								.addComponent(campoTexto, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 1143, Short.MAX_VALUE)))
					.addGap(68))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(campoQuant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelProduto)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblQuantidade))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(campoTexto, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(botaoAceitar)
								.addComponent(botaoCancelar)))
						.addComponent(botaoAd))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNome)
						.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(campoSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelSenha))
					.addGap(135))
		);
		contentPane.setLayout(gl_contentPane);
		}
	//metodo de reescrever o arquivo
	public static void escritor(File f) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(f));
        for (int i = 0; i < produto.length; i++) {
        	if(produto[i]!=null)
        		buffWrite.write(produto[i].getNomeP()+" "+produto[i].getPreco()+" "+produto[i].getId()+" "+produto[i].getQuant()+"\r\n");;
		}
        
        buffWrite.close();
    }

}
