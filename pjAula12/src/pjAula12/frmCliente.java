package pjAula12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class frmCliente extends JFrame implements ActionListener{
	JLabel lbNome, lbCNPJ, lbTelefone, lbStatus;
	JTextField txtNome;
	JFormattedTextField txtCNPJ, txtTelefone;
	JComboBox<String> cbxStatus;
	MaskFormatter mascaraCNPJ, mascaraTelefone;
	String status[] = {"Ativo", "Inativo"};
	JButton btnCadastrar, btnLimpar, btnSair, btnConsultar;
	JPanel pnCampos, pnBotoes;
	BorderLayout layout;
	GridLayout gridCampos, gridBotoes;
	File arquivo = new File("Clientes.txt");
	
	public frmCliente() {
		setTitle("Cadastro de Clientes");
		setLayout(layout = new BorderLayout());
		//setLocationRelativeTo(null);
		setSize(400, 300);
		setLocation(50, 50);
		
		// 2° Passo Instanciação dos objetos
		pnCampos = new JPanel();
		pnBotoes = new JPanel();
		gridCampos = new GridLayout(4, 2);
		gridBotoes = new GridLayout(1, 4);
		lbNome = new JLabel("Razão Social ");
		lbCNPJ = new JLabel("CNPJ ");
		lbTelefone = new JLabel("Telefone");
		lbStatus = new JLabel("Status ");
		
		txtNome = new JTextField(20);
		try {
			mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
			mascaraTelefone = new MaskFormatter("(##)#####-####");
		} catch (ParseException e) {
			System.err.println("Falha na máscara.");
		}
	
		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		
		cbxStatus = new JComboBox<String>(status);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setMnemonic('C');//tecla para atalho(Alt+C) vai cadastrar
		btnCadastrar.setToolTipText("Cadastra um cliente");
		btnCadastrar.addActionListener(this);
		
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setMnemonic('L');
		btnLimpar.setToolTipText("Limpa os campos");
		btnLimpar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.setMnemonic('S');
		btnSair.setToolTipText("Sai do cadastro");
		btnSair.addActionListener(this);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setMnemonic('t');
		btnConsultar.setToolTipText("Consulta cadastro");
		btnConsultar.addActionListener(this);
		
		pnCampos.setLayout(gridCampos);
		pnBotoes.setLayout(gridBotoes);
		
		// 3° Passo adicionar os campos ao Frame
		pnCampos.add(lbNome);
		pnCampos.add(txtNome);
		pnCampos.add(lbCNPJ);
		pnCampos.add(txtCNPJ);
		pnCampos.add(lbTelefone);
		pnCampos.add(txtTelefone);
		pnCampos.add(lbStatus);
		pnCampos.add(cbxStatus);
		add(pnCampos, BorderLayout.NORTH);
		
		pnBotoes.add(btnCadastrar);
		pnBotoes.add(btnLimpar);
		pnBotoes.add(btnConsultar);
		pnBotoes.add(btnSair);
		add(pnBotoes, BorderLayout.SOUTH);
		
		setResizable(false);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCadastrar) {
			try {
				//se o arquivi não existir, cria.
				if (!arquivo.exists()) {
					OutputStream fO = new FileOutputStream("Clientes.txt");
				}
				
				PrintWriter out = new PrintWriter(new FileWriter(arquivo, true));
				out.print(txtNome.getText());
				out.print(" | ");
				out.print(txtCNPJ.getText());
				out.print(" | ");
				out.print(txtTelefone.getText());
				out.print(" | ");
				out.print(status[cbxStatus.getSelectedIndex()]);
				out.close();
				
				JOptionPane.showMessageDialog(null, "Inclusão Realizada com Sucesso!",
						"Inclusão no arquivo Texto", JOptionPane.INFORMATION_MESSAGE);
				setLimpar();
			} catch (IOException erro) {
				JOptionPane.showConfirmDialog(null, "Erro na manipulação do Arquivo Texto" + erro,
						"Erro no Arquivo Texto", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == btnLimpar) {
			setLimpar();
		}
		if(e.getSource() == btnConsultar) {
			frmConsulta consulta = new frmConsulta(arquivo);
			consulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(e.getSource() == btnSair) {
			System.exit(0);
		}
		
	}
	
	public void setLimpar() {
		txtNome.setText("");
		txtCNPJ.setText("");
		txtTelefone.setText("");
		cbxStatus.setSelectedIndex(0);
		txtNome.requestFocus();
	}
	 

	
	public static void main(String[] args) {
		frmCliente frm = new frmCliente();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}



}
