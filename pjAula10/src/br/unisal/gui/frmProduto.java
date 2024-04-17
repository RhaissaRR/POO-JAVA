package br.unisal.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisal.modelagem.Situacao;
import br.unisal.modelagem.UnidadedeMedida;
import br.unisal.modelagem.produto;

public class frmProduto extends JFrame implements ActionListener {
	// 1º PASSO DECLARAR OS OBJETOS
	JLabel lbCodigo, lbDescricao, lbUnidadedeMedida,
			lbLargura, lbComprimento, lbSituacao, lbLocalizacao;
	JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento,
				txtLocalizacao;
	JComboBox cbxUnidadedeMedida, cbxSituacao;
	JPanel pnCampos, pnBotoes;
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa;
	
	List<produto> bdProduto = new ArrayList<produto>();
	
	public frmProduto() {
		super("Cadastro de Produto");
		setSize(500, 250);
		setLayout(new BorderLayout());
	
		// 2° PASSO CONSTRUIR OS OBJETOS
		lbCodigo = new JLabel("Código");
		lbDescricao = new JLabel("Descrição");
		lbUnidadedeMedida = new JLabel("Un. Medida");
		lbLargura = new JLabel("Largura");
		lbComprimento = new JLabel("Comprimento");
		lbSituacao = new JLabel("Situação");
		lbLocalizacao = new JLabel("Localização");
	
		txtCodigo = new JTextField();
		txtDescricao = new JTextField();
		txtLargura = new JTextField();
		txtComprimento = new JTextField();
		txtLocalizacao = new JTextField();
				
		cbxSituacao = new JComboBox<Situacao>(Situacao.values());
		cbxUnidadedeMedida = new JComboBox<String>(UnidadedeMedida.getUnidades());
	
		btnInclui = new JButton("Incluir");
		btnAltera = new JButton("Alterar");
		btnExclui = new JButton("Excluir");
		btnPesquisa = new JButton("Pesquisar");
	
		pnCampos = new JPanel(new GridLayout(7, 2));
		pnBotoes = new JPanel(new GridLayout(1, 4));
	
	
		// 3° PASSO ADICIONAR OS CAMPOS AO FRAME
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
	
		pnCampos.add(lbDescricao);
		pnCampos.add(txtDescricao);
	
		pnCampos.add(lbUnidadedeMedida);
		pnCampos.add(cbxUnidadedeMedida);
	
		pnCampos.add(lbLargura);
		pnCampos.add(txtLargura);
	
		pnCampos.add(lbComprimento);
		pnCampos.add(txtComprimento);
	
		pnCampos.add(lbSituacao);
		pnCampos.add(cbxSituacao);
	
		pnCampos.add(lbLocalizacao);
		pnCampos.add(txtLocalizacao);
	
		add(pnCampos, BorderLayout.CENTER);
	 
		pnBotoes.add(btnInclui);
		pnBotoes.add(btnAltera);
		pnBotoes.add(btnExclui);
		pnBotoes.add(btnPesquisa);
	 
		add(pnBotoes, BorderLayout.SOUTH);
		
		// 4° PASSO INCLUIR OS ELEMENTOS NO LISTENER DE AÇÕES
		btnInclui.addActionListener(this);
		btnAltera.addActionListener(this);
		btnExclui.addActionListener(this);
		btnPesquisa.addActionListener(this);
	 
		setVisible(true);
			
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnInclui) {
			produto p = instanciar();
		}
		
		if (e.getSource() == btnAltera) {
			for (produto p: bdProduto) {
				if (p.getCodigo() == p.getCodigo()) {
					produto objeto = instanciar();
					if (objeto != null) {
						p = objeto;
					}
				
				}
			}
		}
		System.out.println(bdProduto);
			
	}
	
	private produto instanciar() {
		produto p = new produto();
		try {
			p.setCodigo(Integer.parseInt(txtCodigo.getText()));
	
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Código do Produto Inválido", "Válidação", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		p.setDescricao(txtDescricao.getText());
		p.setUn(UnidadedeMedida.values()[cbxUnidadedeMedida.getSelectedIndex()]);

		try {
			p.setLargura(Integer.parseInt(txtLargura.getText()));
	
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Largura do Produto Inválida", "Válidação", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		try {
			p.setComprimento(Integer.parseInt(txtComprimento.getText()));
	
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Comprimento do Produto Inválido", "Válidação", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		p.setSituacao(Situacao.values()[cbxSituacao.getSelectedIndex()]);
		p.setLocalizacao(txtLocalizacao.getText());
						
		return p;
		
	}
	
	public static void main(String[] args) {
		frmProduto frm = new frmProduto();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	
		
	
	
	
	
}