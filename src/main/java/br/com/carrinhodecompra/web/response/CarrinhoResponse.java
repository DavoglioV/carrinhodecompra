package br.com.carrinhodecompra.web.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoResponse {
	private List<ItemResponse> itens;
	
	private BigDecimal valorTotal;

	public CarrinhoResponse() {
		this.itens = new ArrayList<ItemResponse>();
		this.valorTotal = new BigDecimal(0);
	}

	public List<ItemResponse> getItens() {
		return itens;
	}

	public void setItens(List<ItemResponse> itens) {
		this.itens = itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	

//	public Double getValorTotal() {
//		for (Map.Entry<ItemEntity, Integer> item : itens.entrySet()) {
//			this.valorTotal += (item.getKey().getProduto().getValor() * item.getValue());
//		}
//		return valorTotal;
//	}

}
