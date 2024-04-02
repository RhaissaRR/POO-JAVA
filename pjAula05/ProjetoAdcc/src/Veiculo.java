//ActionListenerDemo.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Veiculo extends JFrame implements ActionListener{
	
	//declaração dos objetos
	private JTextField txtPlaca, txtModelo, txtDataCompra, txtFabricante, txtAno,  txtValor;
    private Label lbPlaca, lbModelo, lbDataCompra, lbFrabricante, lbAno, lbValor;
    private  Button btnCadastrar, btnAlterar, btnExcluir, btnPesquisar, btnLimpar, btnSair;
    private GridLayout grid;	
    private JPanel pText, pBotoes;
		
	//construtor
	public Veiculo (){

		super("Cadastro de Veiculos");		
		getContentPane().setLocation(400,400);
		getContentPane().setLayout(new BorderLayout(5,5));
		
		grid = new GridLayout(1,2,5,5);
		
		 lbPlaca = new Label("Placa:");
    	 txtPlaca = new JTextField(15);
    	 lbModelo = new Label("Modelo");
    	 txtModelo = new JTextField(15);
    	 lbDataCompra = new Label("Data da Compra:");
    	 txtDataCompra = new JTextField(15);
    	 lbFrabricante = new Label("Fabricante:");
    	 txtFabricante = new JTextField(15);
    	 lbAno = new Label("Ano de Fabricação");
    	 txtAno = new JTextField(15);
    	 lbValor = new Label("Valor");
    	 txtValor = new JTextField(15);
    	 
    	 btnCadastrar = new Button("Cadastrar");
    	 btnExcluir =new Button("Excluir");
    	 btnAlterar = new Button("Alterar");
    	 btnPesquisar = new Button("Pesquisar");
    	 btnLimpar = new Button("Limpar");
    	 btnSair = new Button("Sair");
    	 
    	 pText.add(lbPlaca);
    	 pText.add(txtPlaca);
    	 pText.add(lbModelo);
    	 pText.add(txtModelo);
    	 pText.add(lbDataCompra);
    	 pText.add(txtDataCompra);
    	 pText.add(lbFrabricante);
    	 pText.add(txtFabricante);
    	 pText.add(lbAno);
    	 pText.add(txtAno);
    	 pText.add(lbValor);
    	 pText.add(txtValor);
    	 
    	 txtPlaca.addActionListener(this);
    	 txtModelo.addActionListener(this);
    	 txtDataCompra.addActionListener(this);
    	 txtFabricante.addActionListener(this);
    	 txtAno.addActionListener(this);
    	 txtValor.addActionListener(this);
    	 
    	 pBotoes.add(btnCadastrar);
    	 pBotoes.add(btnExcluir);
    	 pBotoes.add(btnAlterar);
    	 pBotoes.add(btnPesquisar);
    	 pBotoes.add(btnLimpar);
    	 pBotoes.add(btnSair);
    	 
    	 btnCadastrar.addActionListener(this);
    	 btnExcluir.addActionListener(this);
    	 btnAlterar.addActionListener(this);
    	 btnPesquisar.addActionListener(this);
    	 btnLimpar.addActionListener(this);
    	 btnSair.addActionListener(this);
    	 
    	 //definir o local
    	 pBotoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	 pBotoes.setLayout(grid);
    	 getContentPane().add(pText,BorderLayout.CENTER);
 		getContentPane().add(pBotoes,BorderLayout.SOUTH);
 					
 		setVisible(true);			
	}
	
	//tratador de eventos
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==btnSair) {
			System.exit(0);
		}
	}
	
	//main
	public static void main (String args []){
		Veiculo f = new Veiculo ();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize (400,200);
		//comando para ap�s dar reload no layout
		f.validate();
	}
}