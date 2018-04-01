package br.com.carrinhodecompra.web.request;

import javax.validation.constraints.NotNull;

public class ProdutoRequest {
	
	@NotNull
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
}
