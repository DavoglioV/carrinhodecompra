package br.com.carrinhodecompra.web.response;

import java.math.BigDecimal;

import br.com.carrinhodecompra.model.ProdutoEntity;

public class ItemResponse {
	private ProdutoEntity produto;
	private int quantidade;
	private BigDecimal valorParcial;
	
	public ProdutoEntity getProduto() {
		return produto;
	}
	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getValorParcial() {
		return valorParcial;
	}
	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}
	
	
}
