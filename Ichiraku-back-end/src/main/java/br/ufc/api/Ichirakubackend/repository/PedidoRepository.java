package br.ufc.api.Ichirakubackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.api.Ichirakubackend.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	@Query(value = "SELECT * FROM pedidos WHERE id_user = ?1", nativeQuery=true)
	List<Pedido> findFirstByUsuario(Integer idUser);

}
