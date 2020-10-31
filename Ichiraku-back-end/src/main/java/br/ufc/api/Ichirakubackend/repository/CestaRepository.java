package br.ufc.api.Ichirakubackend.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.api.Ichirakubackend.model.Cesta;


public interface CestaRepository extends JpaRepository<Cesta, Integer> {
	
	@Query(value = "SELECT * FROM cesta WHERE id_usuario = ?1", nativeQuery=true)
	List<Cesta> findFirstByUsuario(Integer idUsuario);
}
