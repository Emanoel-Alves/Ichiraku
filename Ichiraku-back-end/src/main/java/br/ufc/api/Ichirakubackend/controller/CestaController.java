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

import br.ufc.api.Ichirakubackend.model.Cesta;
import br.ufc.api.Ichirakubackend.service.CestaService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/cesta")
public class CestaController {
	
	@Autowired
    CestaService cestaService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cesta>> getItens() {
        return new ResponseEntity<List<Cesta>>(cestaService.getItens(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Cesta> getItem(@PathVariable("id") Integer id) {
        
        Cesta item = cestaService.getItem(id);

		if (item != null) {
			return new ResponseEntity<Cesta>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        
    }
    
//    @RequestMapping(method = RequestMethod.GET, value = "/searchQtd")
//    public ResponseEntity<List<Carro>> getCarroByQuantity(@RequestParam("quantity") Integer quantity) {
//        return new ResponseEntity<List<Carro>>(carroService.getCarroByQuantity(quantity), HttpStatus.OK);
//    }
//    
//    @RequestMapping(method = RequestMethod.GET, value = "/searchMrc")
//    public ResponseEntity<List<Carro>> getCarroByMarca(@RequestParam("marca") String marca) {
//        return new ResponseEntity<List<Carro>>(carroService.getCarroByMarca(marca), HttpStatus.OK);
//    }
 
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cesta> saveItem(@RequestBody Cesta newItem) {
    	
    	if (newItem.getIdPrato() == null || newItem.getIdUsuario() == null || newItem.getValorPrato() == null || newItem.getNomePrato() == null ||
    			newItem.getIdPrato().equals("null") || newItem.getIdUsuario().equals("null") || newItem.getValorPrato().equals("null") || newItem.getNomePrato().equals("null")) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	
        return new ResponseEntity<Cesta>(cestaService.saveItem(newItem), HttpStatus.OK);
    }
 
//    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
//    public ResponseEntity<Produto> updateProduto(@PathVariable("id") Integer id, @RequestBody Produto produto) {
//    	System.out.println(produto.toString());
//    	if (produto.getNome() == null || produto.getIngredientes() == null || produto.getCategoria() == null || produto.getPreco() == 0.0 
//				|| produto.getNome().equals("null") || produto.getIngredientes().equals("null") || produto.getCategoria().equals("null")) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//    	
//        return new ResponseEntity<Produto>(produtoService.updateProduto(produto.getId(), produto.getNome(), produto.getIngredientes(), produto.getPreco(), produto.getCategoria()), HttpStatus.OK);
//    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") Integer id) {
        if (cestaService.deleteItem(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
