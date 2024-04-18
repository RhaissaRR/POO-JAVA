package br.unisal.modelagem;

public enum UnidadedeMedida {
	UN("UN", "Unidade"),
	PC("PC", "Peça"), 
	MT("MT", "Metro"), 
	TON("TON", "TONELADA"), 	
	CX("CX", "Caixa"), 
	DZ("DZ", "Dúzia"), 
	LT("LT", "Litro"), 
	RL("RL", "Rolo");

	private String unidade;
	private String descricao;

	private UnidadedeMedida(String unidade, String descricao) {
		this.unidade = unidade;
		this.descricao = descricao;
	}

	public String getValue(String UN) {
		for (UnidadedeMedida un : UnidadedeMedida.values()) {
			if (un.unidade.equals(UN)) {
				return un.descricao;
			}
		}
		return null;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public static String[] getUnidades() {
		String unidades[] = new String[UnidadedeMedida.values().length];
		int cont = 0;
		for (UnidadedeMedida un : UnidadedeMedida.values()) {
			unidades[cont++] = un.getUnidade() + 
					" - " + un.getDescricao();
		}
		return unidades;
	}
}
