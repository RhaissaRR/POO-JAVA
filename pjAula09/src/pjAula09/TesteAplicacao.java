package pjAula09;

import javax.swing.JOptionPane;

public class TesteAplicacao {
	public static Integer[] vet = new Integer[1_000_000];
	public static void preencher(int numero) {
		try {
 			for (int i=0; i<1_000_001; i++) {
				vet[i]=i;
			}
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Falha ao realizar a ação");
		}
		
		try {
			int valorA = Integer.parseInt(JOptionPane.showInputDialog("Informe um número")) ;
 			int valorB = Integer.parseInt(JOptionPane.showInputDialog("Informe outro número"));
 			JOptionPane.showMessageDialog(null, valorA/valorB);
		}catch (ArithmeticException e) {
			System.out.println("Erro ao dividir por zero");
		}catch (NumberFormatException e) {
			System.out.println("Valor Informado não é um número");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Inicio");
		preencher(1_000_000);
		System.out.println("Fim");
	}

}
