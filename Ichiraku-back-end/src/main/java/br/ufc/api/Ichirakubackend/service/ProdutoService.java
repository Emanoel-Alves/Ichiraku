package br.ufc.api.Ichirakubackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.api.Ichirakubackend.model.Produto;
import br.ufc.api.Ichirakubackend.repository.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
    ProdutoRepository produtoRepository;
    
    public Produto saveProduto(Produto newProduto) {
        return produtoRepository.save(newProduto);
    }
    
    public boolean deleteProduto(Integer id) {
        if(produtoRepository.existsById(id)) {
        	produtoRepository.deleteById(id);
            return true;
        }
        
        return false;
    }
    
    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }
    
    public Produto getProduto(Integer id) {
        return produtoRepository.findById(id).get();
    }
    
//    public List<Produto> getCarroByQuantity(Integer quantity) {
//        return carroRepository.findByQuantity(quantity);
//    }
    
//    public List<Carro> getCarroByMarca(String marca) {
//        return carroRepository.findByMarca(marca);
//    }
    
    public Produto updateProduto(int id, String nome, String ingredientes, double preco, String categoria) {
    	Produto produto = produtoRepository.findById(id).get();
        
        if(produto != null) {
        	produto.setNome(nome);
        	produto.setIngredientes(ingredientes);
        	produto.setPreco(preco);
        	produto.setCategoria(categoria);
        	
        	produtoRepository.save(produto);         
        }
        
        return produto;
    }
}
