package pjAula11;

import java.io.File;

public class PrimeiroTexto {
	public static void main(String[] args) {
		String informacoes = "";
		File arquivo = new File("MeuPrimeiroArquivo.txt");
		File arquivoOutro = new File("../arquivo.csv");
		
		System.out.println(arquivoOutro.getAbsolutePath());
		/*System.out.println(arquivo.exists());
		
		System.out.println(arquivo.canWrite());
		System.out.println(arquivo.isDirectory());
		System.out.println(arquivo.isFile());*/
		
		File integracao = new File("integra/integracao.csv");
		
		if(integracao.exists()) {
			System.out.println("Arquivo existe");
		}else {
			integracao.mkdirs();
		}
		System.out.println(integracao.exists() ? "Existe" : "Não existe");
	}
}
