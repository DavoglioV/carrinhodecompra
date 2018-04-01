package br.com.carrinhodecompra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.carrinhodecompra.model.ProdutoEntity;
import br.com.carrinhodecompra.repository.ProdutoRepository;
import br.com.carrinhodecompra.web.request.ProdutoRequest;
import br.com.carrinhodecompra.web.response.ProdutoResponse;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public ResponseEntity<ProdutoResponse> adicionar(ProdutoRequest paramProduto) {
		ProdutoResponse response = new ProdutoResponse();
		
		ProdutoEntity produto = new ProdutoEntity();
		
		produto.setId(paramProduto.getId());
		produto.setNome(paramProduto.getNome());
		produto.setValor(paramProduto.getValor());
		
		repo.save(produto);
		
		response.setProduto(produto);
		response.setCodigo(200);
		response.setMensagem("Produto adicionado com sucesso.");
		return new ResponseEntity<ProdutoResponse>(response, HttpStatus.CREATED);
	}

	public ResponseEntity<List<ProdutoEntity>> listarTodos() {
		List<ProdutoEntity> produtos = new ArrayList<>();
		produtos = repo.findAll();
		return new ResponseEntity<List<ProdutoEntity>>(produtos, HttpStatus.OK);
	}

	public ResponseEntity<ProdutoResponse> remover(Long id) {
		ProdutoResponse response = new ProdutoResponse();
		repo.delete(id);
		
		response.setCodigo(200);
		response.setMensagem("Produto removido com sucesso.");
		
		return new ResponseEntity<ProdutoResponse>(response, HttpStatus.OK);
	}

}
