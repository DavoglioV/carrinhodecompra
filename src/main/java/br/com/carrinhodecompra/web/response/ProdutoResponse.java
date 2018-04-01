package br.com.carrinhodecompra.web.response;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.carrinhodecompra.model.ProdutoEntity;

public class ProdutoResponse extends GenericResponse{
	
	
	public ProdutoResponse() {
		super();
	}

	public ProdutoResponse(int codigo, String mensagem) {
		super(codigo, mensagem);
	}

	@Autowired
	private ProdutoEntity produto;

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}
	
}

