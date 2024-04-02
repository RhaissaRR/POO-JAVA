/**
 * 
 */
package pjAula02;

/**
 *Classe de Modelagem Conceitual Cliente
 *@author Rhaissa Rodrigues
 *@data 20/02/2024
 */
public class Cliente {
	//Atributos
	private String nome, email;
	private float telefone;
	
	//Método
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getTelefone() {
		return telefone;
	}

	public void setTelefone(float telefone) {
		this.telefone = telefone;
	}
	
	
}
