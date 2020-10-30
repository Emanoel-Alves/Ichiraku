package br.ufc.api.Ichirakubackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.api.Ichirakubackend.model.Pedido;
import br.ufc.api.Ichirakubackend.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedido savePedido(int idUser, String nome, double valorTotal) {
		 Pedido newPedido = new Pedido(idUser, nome, valorTotal );
	     return pedidoRepository.save(newPedido);
	}
	
	 public boolean deletePedido(Integer id) {
	        if(pedidoRepository.existsById(id)) {
	        	pedidoRepository.deleteById(id);
	            return true;
	        }
	        
	      return false;
	 }
	 
	 public List<Pedido> getPedidos() {
	        return pedidoRepository.findAll();
	 }
	 
	 public Pedido getPedido(Integer id) {
	        return pedidoRepository.findById(id).get();
	 }
	 
	  public List<Pedido> getByUsuario(Integer idUser) {
	        return pedidoRepository.findFirstByUsuario(idUser);
	  }
	 
	 public Pedido updatePedido(int id, int idUser, String nome, double valorTotal) {
	    	Pedido pedido = pedidoRepository.findById(id).get();
	        
	        if(pedido != null) {
	        	pedido.setIdUser(idUser);
	        	pedido.setNome(nome);
	        	pedido.setValorTotal(valorTotal);
	        		 
	        	pedidoRepository.save(pedido);         
	        }
	        
	        return pedido;
	  }
	
}
