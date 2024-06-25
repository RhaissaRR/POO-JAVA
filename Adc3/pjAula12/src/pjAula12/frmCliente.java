// Importações necessárias
package pjAula12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

// Classe principal que estende JFrame e implementa ActionListener e ItemListener
public class frmCliente extends JFrame implements ActionListener, ItemListener {
    // Declaração dos componentes da interface gráfica
    JLabel lbNome, lbCNPJ, lbTelefone, lbEmail, lbTipoPessoa, lbDataCadastro, lbFaturamento, lbEstado, lbStatus;
    JTextField txtNome, txtEmail;
    JFormattedTextField txtCNPJ, txtTelefone, txtDataCadastro, txtFaturamento;
    JComboBox<String> cbxTipoPessoa, cbxEstado, cbxStatus;
    MaskFormatter mascaraCNPJ, mascaraTelefone;
    String status[] = {"Ativo", "Inativo"};
    String estados[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
    JButton btnCadastrar, btnLimpar, btnSair, btnConsultar;
    JPanel pnCampos, pnBotoes;
    BorderLayout layout;
    GridLayout gridCampos, gridBotoes;
    File arquivo = new File("Clientes.txt");

    // Construtor da classe
    public frmCliente() {
        // Configurações da janela principal
        setTitle("Cadastro de Clientes");
        setLayout(layout = new BorderLayout());
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Configurações dos painéis
        pnCampos = new JPanel();
        pnBotoes = new JPanel();
        gridCampos = new GridLayout(9, 2);
        gridBotoes = new GridLayout(1, 4);

        // Inicialização dos componentes da interface gráfica
        lbNome = new JLabel(" Razao Social ");
        lbCNPJ = new JLabel(" CNPJ ");
        lbTelefone = new JLabel(" Telefone");
        lbEmail = new JLabel(" Email");
        lbTipoPessoa = new JLabel(" Tipo de Pessoa");
        lbDataCadastro = new JLabel(" Data de Cadastro");
        lbFaturamento = new JLabel(" Faturamento");
        lbEstado = new JLabel(" Estado");
        lbStatus = new JLabel(" Status ");

        // Configurações dos campos de texto formatados
        txtNome = new JTextField(20);
        txtEmail = new JTextField(20);

        try {
            mascaraCNPJ = new MaskFormatter("##.###.###/####-##");
            mascaraTelefone = new MaskFormatter("(##)#####-####");
        } catch (ParseException e) {
            System.err.println("Falha na mascara.");
        }

        txtCNPJ = new JFormattedTextField(mascaraCNPJ);
        txtTelefone = new JFormattedTextField(mascaraTelefone);
        txtDataCadastro = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        txtDataCadastro.setValue(new Date()); // Data atual
        txtFaturamento = new JFormattedTextField(new DecimalFormat("#,##0.00"));

        // Configurações dos JComboBox
        cbxTipoPessoa = new JComboBox<>(new String[]{"Pessoa Física", "Pessoa Jurídica"});
        cbxEstado = new JComboBox<>(estados);
        cbxStatus = new JComboBox<>(status);

        cbxTipoPessoa.addItemListener(this);

        // Configurações dos botões
        btnCadastrar = new JButton("Cadastrar");
        btnLimpar = new JButton("Limpar");
        btnSair = new JButton("Sair");
        btnConsultar = new JButton("Consultar");

        // Adicionando listeners aos botões
        btnCadastrar.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnSair.addActionListener(this);
        btnConsultar.addActionListener(this);

        // Configurações dos layouts dos painéis
        pnCampos.setLayout(gridCampos);
        pnBotoes.setLayout(gridBotoes);

        // Adicionando componentes aos painéis
        pnCampos.add(lbNome);
        pnCampos.add(txtNome);
        pnCampos.add(lbCNPJ);
        pnCampos.add(txtCNPJ);
        pnCampos.add(lbTelefone);
        pnCampos.add(txtTelefone);
        pnCampos.add(lbEmail);
        pnCampos.add(txtEmail);
        pnCampos.add(lbTipoPessoa);
        pnCampos.add(cbxTipoPessoa);
        pnCampos.add(lbDataCadastro);
        pnCampos.add(txtDataCadastro);
        pnCampos.add(lbFaturamento);
        pnCampos.add(txtFaturamento);
        pnCampos.add(lbEstado);
        pnCampos.add(cbxEstado);
        pnCampos.add(lbStatus);
        pnCampos.add(cbxStatus);

        // Adicionando painéis à janela principal
        add(pnCampos, BorderLayout.NORTH);

        pnBotoes.add(btnCadastrar);
        pnBotoes.add(btnLimpar);
        pnBotoes.add(btnConsultar);
        pnBotoes.add(btnSair);

        add(pnBotoes, BorderLayout.SOUTH);

        // Configurações adicionais da janela principal
        setResizable(false);
        setVisible(true);
    }

    // Método de tratamento de eventos para botões e JComboBox
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar) {
            // Ação ao clicar no botão "Cadastrar"
            try {
                // Verifica se o arquivo existe, se não, cria um novo
                if (!arquivo.exists()) {
                    OutputStream fO = new FileOutputStream("Clientes.txt");
                }

                // Escreve os dados do cliente no arquivo
                PrintWriter out = new PrintWriter(new FileWriter(arquivo, true));
                out.print(txtNome.getText());
                out.print(" | ");
                out.print(txtCNPJ.getText());
                out.print(" | ");
                out.print(txtTelefone.getText());
                out.print(" | ");
                out.print(txtEmail.getText());
                out.print(" | ");
                out.print(cbxTipoPessoa.getSelectedItem());
                out.print(" | ");
                out.print(txtDataCadastro.getText());
                out.print(" | ");
                out.print(txtFaturamento.getText());
                out.print(" | ");
                out.print(cbxEstado.getSelectedItem());
                out.print(" | ");
                out.print(status[cbxStatus.getSelectedIndex()]);
                out.println();
                out.close();

                // Exibe mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Inclusão Realizada com Sucesso!", "Inclusão no arquivo Texto", JOptionPane.INFORMATION_MESSAGE);
                // Limpa os campos após a inclusão
                setLimpar();
            } catch (IOException erro) {
                // Exibe mensagem de erro em caso de falha na manipulação do arquivo
                JOptionPane.showConfirmDialog(null, "Erro na manipulação do Arquivo Texto" + erro, "Erro no Arquivo Texto", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Ação ao clicar no botão "Limpar"
        if (e.getSource() == btnLimpar) {
            setLimpar();
        }
        // Ação ao clicar no botão "Consultar"
        if (e.getSource() == btnConsultar) {
            frmConsulta consulta = new frmConsulta(arquivo);
            consulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        // Ação ao clicar no botão "Sair"
        if (e.getSource() == btnSair) {
            System.exit(0);
        }
    }

    // Método de tratamento de evento para mudança de seleção no JComboBox
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // Verifica se a opção selecionada é Pessoa Física
            if (cbxTipoPessoa.getSelectedItem().equals("Pessoa Física")) {
                lbNome.setText("Nome");
                lbCNPJ.setText("CPF");
                try {
                    // Altera a máscara do CNPJ para CPF
                    mascaraCNPJ.setMask("###.###.###-##");
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            } else if (cbxTipoPessoa.getSelectedItem().equals("Pessoa Jurídica")) {
                // Verifica se a opção selecionada é Pessoa Jurídica
                lbNome.setText("Razao Social");
                lbCNPJ.setText("CNPJ");
                try {
                    // Restaura a máscara do CNPJ para Pessoa Jurídica
                    mascaraCNPJ.setMask("##.###.###/####-##");
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Método para limpar os campos do formulário
    public void setLimpar() {
        txtNome.setText("");
        txtCNPJ.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        cbxTipoPessoa.setSelectedIndex(0);
        txtDataCadastro.setValue(new Date());
        txtFaturamento.setValue(null);
        cbxEstado.setSelectedIndex(0);
        cbxStatus.setSelectedIndex(0);
        txtNome.requestFocus();
    }

    // Método main para execução do programa
    public static void main(String[] args) {
        frmCliente frm = new frmCliente();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
