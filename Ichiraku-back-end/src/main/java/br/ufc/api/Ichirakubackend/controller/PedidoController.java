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
import org.springframework.web.bind.annotation.RestController;

import br.ufc.api.Ichirakubackend.model.Pedido;
import br.ufc.api.Ichirakubackend.service.PedidoService;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<List<Pedido>> getPedidos() {
	        return new ResponseEntity<List<Pedido>>(pedidoService.getPedidos(), HttpStatus.OK);
	}
	
	
	 @RequestMapping(method = RequestMethod.GET, value = "{id}")
	    public ResponseEntity<Pedido> getPedido(@PathVariable("id") Integer id) {
//	        return new ResponseEntity<Produto>(produtoService.getProduto(id), HttpStatus.OK);
	        
	        Pedido pedido = pedidoService.getPedido(id);

			if (pedido != null) {
				return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	        
	  }
	 
	 @RequestMapping(method = RequestMethod.POST)
	    public ResponseEntity<Pedido> savePedido(@RequestBody Pedido newPedido) {
	    	
	    	if (newPedido.getNome() == null || newPedido.getIdUser() == 0 || newPedido.getValorTotal() == 0.0 
					|| newPedido.getNome().equals("null")) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	    	
	        return new ResponseEntity<Pedido>(pedidoService.savePedido(newPedido.getIdUser(), newPedido.getNome(), newPedido.getValorTotal() ), HttpStatus.OK);
	  }
	 
	 
	 @RequestMapping(method = RequestMethod.PUT, value = "{id}")
	    public ResponseEntity<Pedido> updatePedido(@PathVariable("id") Integer id, @RequestBody Pedido pedido) {
		 if (pedido.getNome() == null || pedido.getIdUser() == 0 || pedido.getValorTotal() == 0.0 
					|| pedido.getNome().equals("null")) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	    	
	    	
	        return new ResponseEntity<Pedido>(pedidoService.updatePedido(pedido.getId(), pedido.getIdUser(), pedido.getNome(), pedido.getValorTotal()), HttpStatus.OK);
	    }
	 
	 
	 @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	    public ResponseEntity<Void> deletePedido(@PathVariable("id") Integer id) {
	        if (pedidoService.deletePedido(id)) {
	            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	        }
	 
	        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	 }

}
