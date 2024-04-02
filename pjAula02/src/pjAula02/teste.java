package pjAula02;

import java.util.Scanner;

public class teste {
	public static void main(String[] args) {
		/*Automovel carro= new Automovel();
		carro.ano = 1990;
		carro.cor = "Colorido";
		
		System.out.println(carro.ano); 
		
		for(int i=51; i<=171; i++) {
			System.out.println(i);
		}
		
		Cliente voce = new Cliente();
		voce.setNome("Rhaissa");
		System.out.println(voce.getNome());*/
		
		Cliente [] agenda = new Cliente[5];
		
		for(int i=0; i<5; i++) {
			Scanner digito = new Scanner(System.in);
			Cliente elemento = new Cliente();
			
			System.out.println("Informe o nome");
			elemento.setNome(digito.next());
			System.out.println("Informe o telefone");
			elemento.setTelefone(digito.nextFloat());
			System.out.println("Informe o email");
			elemento.setEmail(digito.next());
			
			agenda[i] = elemento;
			digito.close();
		}
		//saida
		for(int i=0; i<5; i++) {
			System.out.println("Nome " + agenda[i].getNome() 
					+" Telefone " + agenda[i].getTelefone()
					+ " Email " + agenda[i].getEmail());
		}
	}

}
