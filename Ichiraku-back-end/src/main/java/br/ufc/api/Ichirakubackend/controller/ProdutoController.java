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

import br.ufc.api.Ichirakubackend.model.Produto;
import br.ufc.api.Ichirakubackend.service.ProdutoService;


@RestController
@CrossOrigin
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
	
	@Autowired
    ProdutoService produtoService;
 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> getProdutos() {
        return new ResponseEntity<List<Produto>>(produtoService.getProdutos(), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable("id") Integer id) {
//        return new ResponseEntity<Produto>(produtoService.getProduto(id), HttpStatus.OK);
        
        Produto produto = produtoService.getProduto(id);

		if (produto != null) {
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
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
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto newProduto) {
    	
    	if (newProduto.getNome() == null || newProduto.getIngredientes() == null || newProduto.getCategoria() == null || newProduto.getPreco() == 0.0 
				|| newProduto.getNome().equals("null") || newProduto.getIngredientes().equals("null") || newProduto.getCategoria().equals("null")) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	
        return new ResponseEntity<Produto>(produtoService.saveProduto(newProduto), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") Integer id, @RequestBody Produto produto) {
    	if (produto.getNome() == null || produto.getIngredientes() == null || produto.getCategoria() == null || produto.getPreco() == 0.0 
				|| produto.getNome().equals("null") || produto.getIngredientes().equals("null") || produto.getCategoria().equals("null")) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    	
        return new ResponseEntity<Produto>(produtoService.updateProduto(produto.getId(), produto.getNome(), produto.getIngredientes(), produto.getPreco(), produto.getCategoria()), HttpStatus.OK);
    }
 
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable("id") Integer id) {
        if (produtoService.deleteProduto(id)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
 
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}
