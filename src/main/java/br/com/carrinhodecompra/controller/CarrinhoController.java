package br.com.carrinhodecompra.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrinhodecompra.exception.ApplicationException;
import br.com.carrinhodecompra.service.CarrinhoService;
import br.com.carrinhodecompra.web.request.ItemRequest;
import br.com.carrinhodecompra.web.response.CarrinhoResponse;
import br.com.carrinhodecompra.web.response.GenericResponse;

@RestController
@RequestMapping("/carrinho")
//@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoController {

	private static final Logger logger = Logger.getLogger(CarrinhoController.class);
	
	@Autowired
	private CarrinhoService service;
	
	@GetMapping
	@RequestMapping( method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<?> busca(){
		ResponseEntity<CarrinhoResponse> response = service.busca();
		return response;
	}
	
	@PostMapping
	@RequestMapping( method = RequestMethod.POST)
	public ResponseEntity<?> adiciona(@RequestBody ItemRequest item){
		ResponseEntity<?> resp;
		try {
			resp = service.adiciona(item);
		} catch (ApplicationException e) {
			logger.error("Erro ao adicionar produto no carrinho: idProduto: " + item.getIdProduto() + " - " + e.getMessage());
			GenericResponse gp = new GenericResponse(e.getCodigo(), e.getMessage());
			resp = new ResponseEntity<GenericResponse>(gp, HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;
	}
	
	@DeleteMapping
	@RequestMapping("/{item}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<?> remove (@PathVariable("item") Long item){
		ResponseEntity<?> resp;
		try {
			resp = service.remove(item);
		} catch (ApplicationException e) {
			logger.error("Erro ao remover produto no carrinho: idProduto: " + item + " - " + e.getMessage());
			GenericResponse gp = new GenericResponse(e.getCodigo(), e.getMessage());
			resp = new ResponseEntity<GenericResponse>(gp, HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping
	@RequestMapping("/{item}/{quantidade}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<?> atualiza (@PathVariable("item") Long item, @PathVariable("quantidade") int qtd){
		ResponseEntity<?> resp;
		try {
			resp = service.atualiza (item, qtd);
		} catch (ApplicationException e) {
			logger.error("Erro ao atualizar produto no carrinho: idProduto: " + item + " - " + e.getMessage());
			GenericResponse gp = new GenericResponse(e.getCodigo(), e.getMessage());
			resp = new ResponseEntity<GenericResponse>(gp, HttpStatus.NOT_FOUND);
			e.printStackTrace();
		}
		return resp;
	}
}
