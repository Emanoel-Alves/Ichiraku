package br.ufc.api.Ichirakubackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ufc.api.Ichirakubackend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>  {
	
	@Query(value = "SELECT * FROM usuarios WHERE email = :email", nativeQuery=true)
	List<Usuario> findUsuarioByEmail(@Param("email")String email);
}
