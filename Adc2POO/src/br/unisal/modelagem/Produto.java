package br.unisal.modelagem;
/**
 * Classe de Modelagem Conceitual de Produto
 * @author Rhaissa Rodrigues
 * @data 18/04/2024
 */
public class Produto {
	// Atributos
	private int codigo;
	private String descricao;
	private UnidadedeMedida un;
	private float largura;
	private float comprimento;
	private Situacao situacao;
	private String localizacao;
	public int getCodigo() {
		return codigo;
	}
	
	
	// Metodos getters and setters

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public UnidadedeMedida getUn() {
		return un;
	}


	public void setUn(UnidadedeMedida un) {
		this.un = un;
	}


	public float getLargura() {
		return largura;
	}


	public void setLargura(float largura) {
		this.largura = largura;
	}


	public float getComprimento() {
		return comprimento;
	}


	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}


	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String toString() {
		return "\nProduto incluido com sucesso"
			+ "\n Código: " + getCodigo() 
			+ "\n Descrição: " + getDescricao()
			+ "\n Unidade de Medida: " + getUn()
			+ "\n Largura: " + getLargura()
			+ "\n Comprimento: " + getComprimento()
			+ "\n Situação: " + getSituacao()
			+ "\n Localização: " + getLocalizacao();
	}
}
