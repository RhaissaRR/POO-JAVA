package pjAula03;

import javax.swing.JOptionPane;

public class TesteConversao {
	public static void main (String[] args) {
		int quantidade;
		
		quantidade = Integer.parseInt(
				JOptionPane.showInputDiaLog(
						"Informe a quantidade"));
		
		float valorPago = quantidade * 10;
		
		JoptionPane.showMessageDialog(null, valorPago);
	}

}
