package br.com.carrinhodecompra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carrinhodecompra.model.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity , Long >{
	
	ProdutoEntity findById(Long id);

}
