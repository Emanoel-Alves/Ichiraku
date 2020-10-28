package br.ufc.api.Ichirakubackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.api.Ichirakubackend.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>   {
	
	@Query(value = "SELECT * FROM produtos WHERE categoria = ?1", nativeQuery=true)
	List<Produto> findFirstByCategoria(String categoria);
	
	@Query(value = "SELECT * FROM produtos limit ?1", nativeQuery=true)
	List<Produto> findFirstByQuantidade(Integer quantidade);
	

}
