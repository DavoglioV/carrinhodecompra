package br.com.carrinhodecompra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.carrinhodecompra.exception.ApplicationException;
import br.com.carrinhodecompra.helper.ErrorEnum;
import br.com.carrinhodecompra.model.CarrinhoEntity;
import br.com.carrinhodecompra.model.ItemEntity;
import br.com.carrinhodecompra.model.ProdutoEntity;
import br.com.carrinhodecompra.repository.ProdutoRepository;
import br.com.carrinhodecompra.web.request.ItemRequest;
import br.com.carrinhodecompra.web.response.CarrinhoResponse;
import br.com.carrinhodecompra.web.response.GenericResponse;
import br.com.carrinhodecompra.web.response.ItemResponse;

@Service
public class CarrinhoService {

	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CarrinhoEntity carrinho;

	public ResponseEntity<CarrinhoResponse> busca() {
		CarrinhoResponse carrinhoResp = new CarrinhoResponse();
		
		for (ItemEntity item : carrinho.busca()) {
			ItemResponse itemResp = new ItemResponse();
			itemResp.setProduto(item.getProduto());
			itemResp.setQuantidade(carrinho.getQuantidade(item));
			itemResp.setValorParcial(carrinho.getTotal(item));
			carrinhoResp.getItens().add(itemResp);
		}
		carrinhoResp.setValorTotal(carrinho.getTotal());
		return new ResponseEntity<CarrinhoResponse>(carrinhoResp, HttpStatus.OK);
	}
	
	public ResponseEntity<GenericResponse> adiciona(ItemRequest paramItem) throws ApplicationException{
		ItemEntity item = preencheItem(paramItem.getIdProduto());
		carrinho.adiciona(item, paramItem.getQuantidade());
		GenericResponse gp = new GenericResponse(200, "Item Adicionado com Sucesso");
		return new ResponseEntity<GenericResponse>(gp, HttpStatus.OK); 
	}

	public ResponseEntity<GenericResponse> remove(Long idItem) throws ApplicationException{
		ItemEntity item = preencheItem(idItem);
		carrinho.remove(item);
		GenericResponse gp = new GenericResponse(200, "Item removido com Sucesso");
		return new ResponseEntity<GenericResponse>(gp, HttpStatus.OK); 
	}
	
	public ResponseEntity<GenericResponse> atualiza(Long idItem, int qtd) throws ApplicationException {
		ItemEntity item = preencheItem(idItem);
		carrinho.atualiza(item, qtd);
		GenericResponse gp = new GenericResponse(200, "Item atualizado com Sucesso");
		return new ResponseEntity<GenericResponse>(gp, HttpStatus.OK);
	}
	
	private ItemEntity preencheItem(Long paramItem) throws ApplicationException {
		ItemEntity item = new ItemEntity();
		ProdutoEntity produto = new ProdutoEntity();
			produto = repo.findById(paramItem);
			if(produto == null) {
				throw new ApplicationException(ErrorEnum.PRODUCT_NOT_FOUND);
			}
		item.setProduto(produto);
		
		return item;
	}

}
