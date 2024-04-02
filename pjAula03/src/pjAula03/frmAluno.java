package pjAula03;

import javax.swing.JFrame;
import javax.swing.JButton;

public class frmAluno extends JFrame {
	//1 Passo declarar o objeto
	JButton btCadastrar, btLimpar;

	public frmAluno() {
		super("Exemplo");
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout());
		
		//2 Passo intanciar o objeto
		btCadastrar= new JButton("Cadastrar");
	}
		//3 Passo adicionar objeto a tela
	 add (btCadastrar);
	 add (btLimpar);
	
	setVisible(true);
	}

	public static void main (String[] args) {
		frmAluno form = new frmAluno();
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

}
