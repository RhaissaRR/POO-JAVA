package projectAdc1Veiculo;

/**
 * Atividade Adc1 
 * Professor Paulo Barreto
 * @author Rhaissa Rodrigues
 * @RA 230024008
 * @data 15/03/2024
 */
// Importações
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


// Definição da classe
public class Veiculo extends JFrame implements ActionListener {
	// Lista para armazenar as placas dos veiculos cadastrados
	private List<String> veiculosCadastrados = new ArrayList<>();
	
	// Componente para entrada de texto
    private JTextField txtPlaca, txtModelo, txtDataCompra, txtAno, txtValor;
    
    // Componete para seção do Fabricante
    private JComboBox<String> cmbFabricante; 
    
    // Botões de ação
    private Button btnCadastrar, btnAlterar, btnExcluir, btnPesquisar, btnLimpar, btnSair;
    
    // Layout para os paines
    private GridLayout grid, grid1, grid2;
    
    // Paines para organização dos componentes
    private JPanel pText1, pText2, pBotoes;

    // Construtor
    public Veiculo() {
        super("Controle de Frota - Cadastro de Veiculos");
        setSize(750, 200);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(15, 15));

        // Configuração dos paines
        grid = new GridLayout(1, 5, 5, 5);
        grid1 = new GridLayout(3, 2, 5, 5);
        grid2 = new GridLayout(3, 2, 5, 5);

        // Inicialização dos componentes 
        txtPlaca = new JTextField(15);
        txtModelo = new JTextField(15);
        txtDataCompra = new JTextField(15);
        txtAno = new JTextField(15);
        txtValor = new JTextField(15);

        btnCadastrar = new Button("Cadastrar");
        btnExcluir = new Button("Excluir");
        btnAlterar = new Button("Alterar");
        btnPesquisar = new Button("Pesquisar");
        btnLimpar = new Button("Limpar");
        btnSair = new Button("Sair");

        pText1 = new JPanel();
        pText2 = new JPanel();
        pBotoes = new JPanel();
        
     // Criação e configuração do JComboBox
        cmbFabricante = new JComboBox<>();
        cmbFabricante.addItem("CHEVROLET");
        cmbFabricante.addItem("FORD");
        cmbFabricante.addItem("TOYOTA");
        cmbFabricante.addItem("HONDA");
        cmbFabricante.addItem("HYUNDAY");
        cmbFabricante.addItem("FIAT");
        
        // Adicionando componentes aos paineis
        pText1.add(new JLabel("Placa do Veiculo:"));
        pText1.add(txtPlaca);

        pText1.add(new JLabel("Modelo do Veiculo:"));
        pText1.add(txtModelo);

        pText1.add(new JLabel("Data da Compra:"));
        pText1.add(txtDataCompra);

        pText2.add(new JLabel("Fabricante:")); // Adicionando um label
        pText2.add(cmbFabricante); // Adicionando o JComboBox

        pText2.add(new JLabel("Ano da Fabricação:"));
        pText2.add(txtAno);

        pText2.add(new JLabel("Valor de Compra (R$):"));
        pText2.add(txtValor);

        // Adicionando listeners aos botoes
        btnCadastrar.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnAlterar.addActionListener(this);
        btnPesquisar.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnSair.addActionListener(this);

        // Adicionando botoes no painel de botoes
        pBotoes.add(btnCadastrar);
        pBotoes.add(btnExcluir);
        pBotoes.add(btnAlterar);
        pBotoes.add(btnPesquisar);
        pBotoes.add(btnLimpar);
        pBotoes.add(btnSair);
        
        // Desabilitando os botoes excluir e alterar no inicio
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);

        // Configuração do cursor para o painel dos botoes
        pBotoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        // Configuração do layout dos paineis 
        pBotoes.setLayout(grid);
        pText1.setLayout(grid1);
        pText2.setLayout(grid2);

        // Adiconando os paineis no JFrame
        getContentPane().add(pText1, BorderLayout.WEST);
        getContentPane().add(pText2, BorderLayout.EAST);
        getContentPane().add(pBotoes, BorderLayout.SOUTH);
        
        // Configuração da borda do JFrame e dos paineis de texto
        Border border = BorderFactory.createLineBorder(new Color(0, 0, 0, 0));
        ((JComponent) getContentPane()).setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        Border borderText = BorderFactory.createTitledBorder("Informações do Veículo");
        pText1.setBorder(borderText); 
        pText2.setBorder(borderText);

        // Torna o JFrame visivel
        setVisible(true);
    }

    // Metodo de ação dos componentes 
    @Override
    public void actionPerformed(ActionEvent e) {  	   	
    	if (e.getSource() == btnCadastrar) {
            // Se o evento foi gerado pelo botão btnCadastrar, chama o método cadastrar()
            cadastrar();
            
        } else if (e.getSource() == btnAlterar) {
            // Se o evento foi gerado pelo botão btnAlterar, chama o método alterar()
            alterar();
            
        } else if (e.getSource() == btnExcluir) {
            // Se o evento foi gerado pelo botão btnExcluir, chama o método excluir()
            excluir();
            
        } else if (e.getSource() == btnPesquisar) {
            // Se o evento foi gerado pelo botão btnPesquisar, chama o método pesquisar()
            pesquisar();
            
        } else if (e.getSource() == btnLimpar) {
            // Se o evento foi gerado pelo botão btnLimpar, chama o método limpar()
            limpar();
            
        } else if (e.getSource() == btnSair) {
            // Se o evento foi gerado pelo botão btnSair, fecha o JFrame
            dispose();
        }
}
    
    // Metodo para cadastrar o veiculo
    private void cadastrar() {
    		String placa = txtPlaca.getText().toUpperCase();
            String modelo = txtModelo.getText();
            String dataCompra = txtDataCompra.getText();
            String fabricante = (String) cmbFabricante.getSelectedItem();
            String ano = txtAno.getText();
            String valor = txtValor.getText();

            // Verifica se algum dos campos está vazio
            if (placa.isEmpty() || modelo.isEmpty() || dataCompra.isEmpty() || fabricante.isEmpty() || ano.isEmpty() || valor.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos para cadastrar o veículo!", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
            } else {
                // Mensagem que será exibida no JOptionPane
                String mensagem = "Veículo cadastrado com sucesso!\n" +
                                  "Placa: " + placa + "\n" +
                                  "Modelo: " + modelo + "\n" +
                                  "Data da compra: " + dataCompra + "\n" +
                                  "Fabricante: " + fabricante + "\n" +
                                  "Ano: " + ano + "\n" +
                                  "Valor (R$): " + valor;
                // Habilita os botões de alterar e excluir após o cadastro
                btnAlterar.setEnabled(true);
                btnExcluir.setEnabled(true);
                
             // Adiciona a placa do veículo cadastrado à lista
                veiculosCadastrados.add(placa); 
                
                // Exibe a mensagem de confirmação
                JOptionPane.showMessageDialog(this, mensagem, "Cadastro de Veículo", JOptionPane.INFORMATION_MESSAGE);

             // Limpa os campos de entrada de texto e redefine o índice do fabricante para o primeiro item
                limpar();
            }
	}
   
    // Metodo para alterar
    private void alterar() {
        // Obtenha a placa do veículo a ser alterado
        String placaAlterar = JOptionPane.showInputDialog(this, "Digite a placa do veículo a ser alterado:");

        // Verifique se a placa existe na lista de veículos cadastrados
        if (veiculosCadastrados.contains(placaAlterar)) {
            // Aqui você pode implementar a lógica para alterar os dados do veículo
            // Por exemplo, você pode buscar o veículo na lista, modificar seus atributos e atualizar a lista
            // Neste exemplo, estou apenas exibindo uma mensagem
            JOptionPane.showMessageDialog(this, "Veículo encontrado para alteração.", "Alteração de Veículo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Veículo não encontrado!", "Alteração de Veículo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
	// Método para excluir um veículo
	private void excluir() {
		// Obtenha a placa do veículo a ser excluído
	    String placaExcluir = JOptionPane.showInputDialog(this, "Digite a placa do veículo a ser excluído:");
	    // Verifique se a placa existe na lista de veículos cadastrados
	    if (veiculosCadastrados.contains(placaExcluir)) {
	        // Remova o veículo da lista
	        veiculosCadastrados.remove(placaExcluir);
	        JOptionPane.showMessageDialog(this, "Veículo excluído com sucesso!", "Exclusão de Veículo", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(this, "Veículo não encontrado!", "Exclusão de Veículo", JOptionPane.ERROR_MESSAGE);
	    }
    }
	
	// Metodo para pesquisar um veiculo
	private void pesquisar() {
	    String placaPesquisar = JOptionPane.showInputDialog(this, "Digite a placa do veículo a ser pesquisado:");
	    
	    if (veiculosCadastrados.contains(placaPesquisar)) {
	        JOptionPane.showMessageDialog(this, "Veículo encontrado!", "Pesquisa de Veículo", JOptionPane.INFORMATION_MESSAGE);
	    } else {
	        JOptionPane.showMessageDialog(this, "Veículo não encontrado!", "Pesquisa de Veículo", JOptionPane.ERROR_MESSAGE);
	    }
	}

    // Metodo para limpar os campos de entrada de texto
	private void limpar() {
        	// Limpa as caixa  de Texto
			txtPlaca.setText("");
			txtModelo.setText("");
			txtDataCompra.setText("");
			txtAno.setText("");
			txtValor.setText("");
			cmbFabricante.setSelectedIndex(0);
			
			// Requisita o foco da ação para o primeiro campo
			txtPlaca.requestFocus();
	}
	
	// Metodo principal
	public static void main(String[] args) {
        Veiculo f = new Veiculo();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
