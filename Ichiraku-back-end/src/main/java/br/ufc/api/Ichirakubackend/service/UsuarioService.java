package br.ufc.api.Ichirakubackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.api.Ichirakubackend.model.Usuario;
import br.ufc.api.Ichirakubackend.repository.UsuarioRepository;

@Service
public class UsuarioService {
 
    @Autowired
    UsuarioRepository usuarioRepo;
    
    public Usuario addUsuario(String nome, String sobrenome, String email, String senha, String cidade, String bairro,
			String rua, String numero, boolean imagem) {
    	Usuario usuario = new Usuario(nome, sobrenome, email, senha, cidade, bairro, rua, numero, imagem);
    	System.out.println(usuario.toString());
        return usuarioRepo.save(usuario);
    }
    
    public boolean removeUsuario(Integer id) {
        if(usuarioRepo.existsById(id)) {
        	usuarioRepo.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarioRepo.findAll();
    }
    
    public Usuario getUsuario(Integer id) {
        return usuarioRepo.findById(id).get();
    }
    
    public List<Usuario> getUsuarioByEmail(String email) {
        return usuarioRepo.findUsuarioByEmail(email);
    }
    
    public Usuario updateUsuario(Integer id, String nome, String sobrenome, String email, String senha, String cidade, String bairro,
			String rua, String numero, boolean imagem) {
        Usuario usuarioAux = usuarioRepo.findById(id).get();
        
        if(usuarioAux != null) {
        	usuarioAux.setNome(nome);
        	usuarioAux.setSobrenome(sobrenome);
            usuarioAux.setEmail(email);
            usuarioAux.setSenha(senha);
            usuarioAux.setCidade(cidade);
            usuarioAux.setBairro(bairro);
            usuarioAux.setRua(rua);
            usuarioAux.setNumero(numero);
            usuarioAux.setImagem(imagem);
            
            usuarioRepo.save(usuarioAux);         
        }
        
        return usuarioAux;
    }
}