package br.com.carrinhodecompra.controller;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrinhodecompra.model.ProdutoEntity;
import br.com.carrinhodecompra.service.ProdutoService;
import br.com.carrinhodecompra.web.request.ProdutoRequest;
import br.com.carrinhodecompra.web.response.ProdutoResponse;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins="*")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@PostMapping
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produto){
		ResponseEntity<ProdutoResponse> response = service.adicionar(produto);
		return response;
	}
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<ProdutoEntity>> listar(){
		ResponseEntity<List<ProdutoEntity>> response = service.listarTodos();
		return response;
	}
	
	@DeleteMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ProdutoResponse> remover(@PathVariable Long id){
		ResponseEntity<ProdutoResponse> response = service.remover(id);
		return response;
	}
}
