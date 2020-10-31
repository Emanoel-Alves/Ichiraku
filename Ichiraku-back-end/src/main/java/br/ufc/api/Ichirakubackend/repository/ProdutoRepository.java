package br.ufc.api.Ichirakubackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.api.Ichirakubackend.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>   {

}
