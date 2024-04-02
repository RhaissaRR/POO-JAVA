package pjAula05;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Exemplo de Gerenciador de Layout
 * @author Rhaissa Rodrigues
 *
 */
public class frmCadastro extends JFrame implements ActionListener {
	//1- Passo Declaracção
	JButton btnCadastrar, btnLimpar;
	JTextField txtNome, txtSenha;
	JLabel lbNome, lbSenha;
	JPanel pnCampos, pnBotoes, pnGrid;
	JButton vetBotoes[];
	
	public frmCadastro() {
		super("Login");
		setSize(240, 240);
		setLayout(new BorderLayout());
		
		//2- Passo construção
		lbNome = new JLabel("Nome");
		lbSenha = new JLabel("Senha");
		txtNome = new JTextField(20);
		txtSenha = new JTextField(20);
		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
		pnCampos = new JPanel(new FlowLayout());
		pnBotoes = new JPanel(new FlowLayout());
		pnGrid = new JPanel(new GridLayout(4,4));
		
		vetBotoes = new JButton[16];
		
		for (int i=0; i<=9; i++) {
			JButton botao = new JButton(String.valueOf(i));
			vetBotoes[i] = botao;
		}
		
		//3- Passo adicionar os elementos a GUI
		pnCampos.add(lbNome);
		pnCampos.add(txtNome);
		pnCampos.add(lbSenha);
		pnCampos.add(txtSenha);
		
		pnBotoes.add(btnCadastrar);
		pnBotoes.add(btnLimpar);
		
		for (int i=0; i<=9; i++) {
			pnGrid.add(vetBotoes[i]);
			vetBotoes[i].addActionListener(this);
		}
		
		add(pnCampos, new BorderLayout().NORTH);
		add(pnGrid, new BorderLayout().CENTER);
		add(pnBotoes, new BorderLayout().SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		frmCadastro frm = new frmCadastro();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			txtNome.setText(e.getSource().toString());
	}
	
}
