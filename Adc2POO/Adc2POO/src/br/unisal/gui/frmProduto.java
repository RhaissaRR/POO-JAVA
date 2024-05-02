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
import javax.swing.SwingUtilities;

import br.unisal.modelagem.Produto;
import br.unisal.modelagem.Situacao;
import br.unisal.modelagem.UnidadedeMedida;

public class frmProduto extends JFrame implements ActionListener {
	// 1º PASSO DECLARAR OS OBJETOS
	JLabel lbCodigo, lbDescricao, lbUnidadedeMedida,
			lbLargura, lbComprimento, lbSituacao, lbLocalizacao;
	JTextField txtCodigo, txtDescricao, txtLargura, txtComprimento,
				txtLocalizacao;
	JComboBox cbxUnidadedeMedida, cbxSituacao;
	JPanel pnCampos, pnBotoes;
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa, btnLimpa;
	List<Produto> bdProduto = new ArrayList<Produto>();

	public frmProduto() {
		super("Cadastro de Produto");
		setSize(500, 250);
		setLocationRelativeTo(null);
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
		btnLimpa = new JButton("Limpar");

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
		
		//Adiciona os botoes ao frame
		pnBotoes.add(btnInclui);
		pnBotoes.add(btnAltera);
		pnBotoes.add(btnExclui);
		pnBotoes.add(btnPesquisa);
		pnBotoes.add(btnLimpa);

		add(pnBotoes, BorderLayout.SOUTH);

		// 4° PASSO INCLUIR OS ELEMENTOS NO LISTENER DE AÇÕES
		btnInclui.addActionListener(this);
		btnAltera.addActionListener(this);
		btnExclui.addActionListener(this);
		btnPesquisa.addActionListener(this);
		btnLimpa.addActionListener(this);
		
		btnExclui.setEnabled(false);
		btnAltera.setEnabled(false);
		
		//torna visivel
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		//eventos
		if (e.getSource() == btnInclui) {
			Incluir();
		}
		if (e.getSource() == btnAltera) {
			Alterar();
		}
		if(e.getSource() == btnExclui) {
			Excluir();
		}
		if(e.getSource() == btnPesquisa) {
			Pesquisar();
		}
		if(e.getSource() == btnLimpa) {
			Limpar();
		}
	}
	
	private void Incluir() {
		Produto p = instanciar();
		if(p != null) {
			bdProduto.add(p);
			btnAltera.setEnabled(true);
		}
		Limpar();
		JOptionPane.showMessageDialog(this, bdProduto);
	}
	
	private void Alterar() {
		String codigoAlterar = JOptionPane.showInputDialog(this, "Digite o código do produto a ser Alterado.");
		if (codigoAlterar == null || codigoAlterar.isEmpty()) {
            return; // Cancelado pelo usuário
        }

		//Verifica se é valido
		try {
			int codigo = Integer.parseInt(codigoAlterar);
			boolean produtoEncrontrado = false;
		
			//Procura o produto na lista bdProduto
			for(Produto produto : bdProduto) {
				if (produto.getCodigo() == codigo) {
					produtoEncrontrado = true;
					//Desabilita a caixa de codigo
					txtCodigo.setEnabled(false);
					// preenche os campos com os dados
					txtDescricao.setText(produto.getDescricao());
					cbxUnidadedeMedida.setSelectedItem(produto.getUn().toString());
					txtLargura.setText(String.valueOf(produto.getLargura()));
					txtComprimento.setText(String.valueOf(produto.getComprimento()));
					cbxSituacao.setSelectedItem(produto.getSituacao().toString());
					txtLocalizacao.setText(produto.getLocalizacao());
					break;
					
				}	
			}
			if (!produtoEncrontrado) {
				JOptionPane.showMessageDialog(this, "Produto não localizado para alteração",
						"Alteraçao do Produto", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}catch (NumberFormatException ep) {
			JOptionPane.showMessageDialog(this, "Digite um código válido",
					"Erro", JOptionPane.ERROR_MESSAGE);			
		}

	}
	
	private void Excluir() {
	    String codigoStr = JOptionPane.showInputDialog(this, "Digite o código do produto a ser excluído:");
	    if (codigoStr == null || codigoStr.isEmpty()) {
	        return; // Se o usuário cancelar ou não fornecer um código, sai sem fazer nada
	    }

	    try {
	        int codigo = Integer.parseInt(codigoStr);
	        boolean produtoEncontrado = false;

	        for (Produto produto : bdProduto) {
	            if (produto.getCodigo() == codigo) {
	                produto.setSituacao(Situacao.EXCLUIDO);
	                produtoEncontrado = true;
	                break;
	            }
	        }

	        if (produtoEncontrado) {
	            JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
	            JOptionPane.showMessageDialog(this, bdProduto);
	            btnExclui.setEnabled(false); // Desativar o botão de exclusão após a exclusão
	        } else {
	            JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Código inválido. Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
	    }

	    Limpar();
	}

	private void Pesquisar() {
	    // Verifica se há algum produto carregado (se o campo de código está desativado)
	    if (!txtCodigo.isEnabled()) {
	        // Limpar formulário e reativar inserir e pesquisar
	        Limpar();
	        txtCodigo.setEnabled(true);
	        btnInclui.setEnabled(true);
	        return;
	    }

	    String codigoStr = JOptionPane.showInputDialog(this, "Digite o código do produto a pesquisar:");
	    if (codigoStr == null || codigoStr.isEmpty()) {
	        return; // Se o usuário cancelar ou não fornecer um código, sai sem fazer nada
	    }

	    try {
	        int codigo = Integer.parseInt(codigoStr);
	        boolean produtoEncontrado = false;

	        for (Produto produto : bdProduto) {
	            if (produto.getCodigo() == codigo) {
	                produtoEncontrado = true;
	                // Preenche os campos com os dados do produto encontrado
	                txtCodigo.setText(String.valueOf(produto.getCodigo()));
	                txtDescricao.setText(produto.getDescricao());
	                cbxUnidadedeMedida.setSelectedItem(produto.getUn().toString());
	                txtLargura.setText(String.valueOf(produto.getLargura()));
	                txtComprimento.setText(String.valueOf(produto.getComprimento()));
	                cbxSituacao.setSelectedItem(produto.getSituacao().toString());
	                txtLocalizacao.setText(produto.getLocalizacao());

	                // Desativa o campo de código após encontrar o produto
	                txtCodigo.setEnabled(false);
	                btnInclui.setEnabled(false); // Desativa o botão "Incluir"
	                break;
	            }
	        }

	        if (!produtoEncontrado) {
	            JOptionPane.showMessageDialog(this, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Código inválido. Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void Limpar() {
		txtCodigo.setText("");
		txtDescricao.setText("");
		txtLargura.setText("");
		txtComprimento.setText("");
		txtLocalizacao.setText("");
		txtCodigo.setEnabled(true);
		cbxUnidadedeMedida.setSelectedItem(0);
		cbxSituacao.setSelectedIndex(0);
		txtCodigo.requestFocus();	
	}
	
	private Produto instanciar() {
	    Produto p = new Produto();
	    try {
	        p.setCodigo(Integer.parseInt(txtCodigo.getText()));
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Código do Produto Inválido", "Validação", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }

	    p.setDescricao(txtDescricao.getText());
	    p.setUn(UnidadedeMedida.values()[cbxUnidadedeMedida.getSelectedIndex()]);

	    try {
	        p.setLargura(Integer.parseInt(txtLargura.getText()));
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Largura do Produto Inválida", "Validação", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }

	    try {
	        p.setComprimento(Integer.parseInt(txtComprimento.getText()));
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(null, "Comprimento do Produto Inválida", "Validação", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }

	    p.setSituacao(Situacao.values()[cbxSituacao.getSelectedIndex()]);
	    p.setLocalizacao(txtLocalizacao.getText());

	    // Verifica se a situação do produto é EXCLUIDO para desativar o botão de exclusão
	    if (p.getSituacao() == Situacao.EXCLUIDO) {
	        btnExclui.setEnabled(false);
	    } else {
	        btnExclui.setEnabled(true);
	    }

	    return p;
	}
	
	public static void main(String[] args) {
		frmProduto frm = new frmProduto();
        frm.setVisible(true);
        
	}
}