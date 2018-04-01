package br.com.carrinhodecompra.web.response;

public class GenericResponse {
	int codigo;
	String mensagem;
	String descricao;
	
	
	public GenericResponse() {
		super();
	}
	
	public GenericResponse(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
