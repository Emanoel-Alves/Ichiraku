package br.ufc.api.Ichirakubackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.api.Ichirakubackend.model.Cesta;
import br.ufc.api.Ichirakubackend.repository.CestaRepository;

@Service
public class CestaService {
	
	@Autowired
    CestaRepository cestaRepository;
    
    public Cesta saveItem(Cesta newItem) {
        return cestaRepository.save(newItem);
    }
    
    public boolean deleteItem(Integer id) {
        if(cestaRepository.existsById(id)) {
        	cestaRepository.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Cesta> getItens() {
        return cestaRepository.findAll();
    }
    
    public Cesta getItem(Integer id) {
        return cestaRepository.findById(id).get();
    }
    
    public List<Cesta> getByUsuario(Integer idUsuario) {
        return cestaRepository.findFirstByUsuario(idUsuario);
    }

}
