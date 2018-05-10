package parteGrafica;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import projetoFinal.Produto;

import projetoFinal.Produto;
//No geral essa parte so vai ter dois RadioButton que servirá para saber se vai ter que adicionar um novo produto ou apenas adiconar um produto que ja existe.
public class Estoque extends JFrame {
	private String[] t2;
	private String t;
	private int quant=0;
	private static Produto[] produto = new Produto[50];
	private JPanel contentPane;
	private JRadioButton botaoN;
	private JRadioButton botaoE;
	private JTextField campoNome;
	private JTextField campoPreco;
	private JTextField campoQuant;
	private JTextField campoId;
	private JLabel labelId;
	private JButton botaoAdicionar;
	private JComboBox comboBox;
	public Estoque() throws NumberFormatException, IOException {
		//Aqui carrego o arquivo e os valores deles como fiz no Interface
		File file= new File("t.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		while((this.t=br.readLine() )!= null) {
			t2=t.split(" ");
			produto[quant] = new Produto(t2[0],Double.parseDouble(t2[1]),Integer.parseInt(t2[2]),Integer.parseInt(t2[3]));
			quant++;
		}
		JLabel labelNome = new JLabel("Nome do produto");
		//Aqui estão os campos e label 
		campoNome = new JTextField();
		campoNome.setColumns(10);
		
		campoPreco = new JTextField();
		campoPreco.setColumns(10);
		
		JLabel labelPreco = new JLabel("Preco do produto");
		
		campoQuant = new JTextField();
		campoQuant.setColumns(10);
		
		JLabel labelQuant = new JLabel("Quantidade do produto");
		//Aqui os eventos dos botoes, se tal botao for pressionado ele desabilita certos campos e label
		JRadioButton rdbtnNewRadioButton;
		botaoN = new JRadioButton("Novo Produto");
		botaoN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoPreco.setEnabled(true);
				labelPreco.setEnabled(true);
				campoNome.setEnabled(true);
				labelNome.setEnabled(true);
				campoId.setEnabled(false);
				labelId.setEnabled(false);
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1;
		botaoE = new JRadioButton("Produto ja existente");
		botaoE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campoPreco.setEnabled(false);
				labelPreco.setEnabled(false);
				campoNome.setEnabled(false);
				labelNome.setEnabled(false);
				campoId.setEnabled(true);
				labelId.setEnabled(true);
			}
		});
		ButtonGroup bg = new ButtonGroup();
		bg.add(botaoN);
		bg.add(botaoE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		campoId = new JTextField();
		campoId.setColumns(10);
		
		labelId = new JLabel("ID do produto");
		//Aqui o evento do botao adicionar, existe uma condição nele para saber se vai adicionar um  novo produto ou um ja existente
		botaoAdicionar = new JButton("Adicionar");
		botaoAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botaoE.isSelected()){
					if(campoId.getText().equals("") || campoQuant.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Ocorreu um erro");
					}
					else {
						produto[Integer.parseInt(campoId.getText())].setQuant(produto[Integer.parseInt(campoId.getText())].getQuant()+Integer.parseInt(campoQuant.getText()));
						try {
							escritor(file);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
					}
				}
				else {
					if(campoQuant.getText().equals("") || campoNome.getText().equals("") || campoPreco.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Ocorreu um erro");
					}
					else {
						try {
							adicionar(file,campoNome.getText()+" "+campoPreco.getText()+" "+quant+" "+campoQuant.getText()+"\r\n");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
					}
				}
					
			}
		});
		
		comboBox = new JComboBox();
		for (int i = 0; i <quant; i++) {
			comboBox.addItem("nome: " + produto[i].getNomeP()+"  ||  preco: R$ "+produto[i].getPreco()+"  ||  Quantidade em estoque: "+produto[i].getQuant()+"  ||  Id: "+produto[i].getId());
		}
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(botaoN)
										.addComponent(botaoE))
									.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(labelNome)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(labelPreco)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(campoPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(labelQuant)
											.addComponent(labelId))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(campoId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(campoQuant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(botaoAdicionar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(botaoN)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(botaoE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelNome)
								.addComponent(campoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelPreco)
								.addComponent(campoPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(labelQuant))
								.addComponent(campoQuant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(campoId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelId))
							.addGap(18)
							.addComponent(botaoAdicionar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	//metodo de reescrever no arquivo
	public static void escritor(File f) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(f));
        for (int i = 0; i < produto.length; i++) {
        	if(produto[i]!=null)
        		buffWrite.write(produto[i].getNomeP()+" "+produto[i].getPreco()+" "+produto[i].getId()+" "+produto[i].getQuant()+"\r\n");;
		}
        
        buffWrite.close();
    }
	//metodo de adicionar no arquivo
	public static void adicionar(File f,String p) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(f,true));
        buffWrite.write(p);
        buffWrite.close();
    }
}
