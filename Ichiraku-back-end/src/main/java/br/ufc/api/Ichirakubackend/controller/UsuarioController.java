package br.ufc.api.Ichirakubackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.api.Ichirakubackend.model.Usuario;
import br.ufc.api.Ichirakubackend.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getUUsuarios() {
		return new ResponseEntity<List<Usuario>>(usuarioService.getUsuarios(), HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.GET, value = "{id}")
//	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Integer id) {
//		return new ResponseEntity<Usuario>(usuarioService.getUsuario(id), HttpStatus.OK);
//	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Integer id) {

		Usuario usuario = usuarioService.getUsuario(id);

		if (usuario != null) {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/search")
	public ResponseEntity<List<Usuario>> getUsuarioByEmail(@RequestParam("email") String email) {
		return new ResponseEntity<List<Usuario>>(usuarioService.getUsuarioByEmail(email), HttpStatus.OK);
	}

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
//        return new ResponseEntity<Usuario>(usuarioService.addUsuario(usuario.getNome(), usuario.getSobrenome(), usuario.getEmail(), usuario.getSenha(), usuario.getCidade(), usuario.getBairro(), usuario.getRua(), usuario.getNumero()), HttpStatus.OK);
//    }

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario newUsuario) {

		if (newUsuario.getNome() == null || newUsuario.getEmail() == null || newUsuario.getSenha() == null
				|| newUsuario.getNome().equals("null") || newUsuario.getEmail().equals("null")
				|| newUsuario.getSenha().equals("null")) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuarioService.addUsuario(newUsuario.getNome(), newUsuario.getSobrenome(),
				newUsuario.getEmail(), newUsuario.getSenha(), newUsuario.getCidade(), newUsuario.getBairro(),
				newUsuario.getRua(), newUsuario.getNumero()), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {

		if (usuario.getNome() == null || usuario.getEmail() == null || usuario.getSenha() == null
				|| usuario.getNome().equals("null") || usuario.getEmail().equals("null")
				|| usuario.getSenha().equals("null") || usuario.getCidade().equals("null")
				|| usuario.getBairro().equals("null") || usuario.getRua().equals("null")
				|| usuario.getNumero().equals("null") || usuario.getSobrenome().equals("null")){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuarioService.updateUsuario(usuario.getId(), usuario.getNome(), usuario.getSobrenome(),
				usuario.getEmail(), usuario.getSenha(), usuario.getCidade(), usuario.getBairro(), usuario.getRua(),
				usuario.getNumero()), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable("id") Integer id) {
		if (usuarioService.removeUsuario(id)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}