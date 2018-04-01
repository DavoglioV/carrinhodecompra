package br.com.carrinhodecompra.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component("carrinho")
//@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class CarrinhoEntity {
	
	private Map<ItemEntity, Integer> itens = new LinkedHashMap<>();
	
	private Double valorTotal;

	public Collection<ItemEntity> busca() {
		return itens.keySet();
		
	}
	public void adiciona(ItemEntity item, int i) {
		itens.put(item, getQuantidade(item) + i);
	}
	
	public void remove(ItemEntity item) {
		itens.remove(item);
	}

	public void atualiza(ItemEntity item, int qtd) {
		itens.remove(item);
		itens.put(item, qtd);
		
	}
	
	public int getQuantidade(ItemEntity item) {
		if(!itens.containsKey(item)) {
			itens.put(item, 0);
		}
		return itens.get(item);
	}
	
	//usado para exibir a quantidade de itens que tem no carrinho
	public int getQuantidade() {
		return itens.values().stream().reduce(0, (proximo, acumulador) -> (proximo + acumulador));
	}
	
	public BigDecimal getTotal(ItemEntity item){
	    return item.getTotal(getQuantidade(item));
	}
	
	public BigDecimal getTotal(){
	    BigDecimal total = BigDecimal.ZERO;
	    for (ItemEntity item : itens.keySet()) {
	        total = total.add(getTotal(item));
	    }
	    return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		CarrinhoEntity other = (CarrinhoEntity) obj;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}

	public Map<ItemEntity, Integer> getItens() {
		return itens;
	}

	public void setItens(Map<ItemEntity, Integer> itens) {
		this.itens = itens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	
}
