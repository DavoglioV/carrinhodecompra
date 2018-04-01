package br.com.carrinhodecompra.model;

import java.math.BigDecimal;

public class ItemEntity {

	private ProdutoEntity produto;
	
	//private Integer quantidade;
	
	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEntity other = (ItemEntity) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}

	public BigDecimal getTotal(int quantidade) {
		return new BigDecimal( this.getProduto().getValor() * quantidade);
	}


//	public Integer getQuantidade() {
//		return quantidade;
//	}
//
//	public void setQuantidade(Integer quantidade) {
//		this.quantidade = quantidade;
//	}
//
//	public Double getValorParcial() {
//		return this.getProduto().getValor() * this.quantidade;
//	}
	
	
}
