package br.com.carrinhodecompra.helper;

public enum ErrorEnum {

	PRODUCT_NOT_FOUND(404, "Produto informado não cadastrado na base.");
	
	private int codigo;
	private String descricao;
	
	ErrorEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
}
