package com.avanade.dio.api.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.avanade.dio.api.models.Produto;
import com.avanade.dio.api.repository.LojaRepository;
import com.avanade.dio.api.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Iterable<Produto> findAll(){
        return produtoRepository.findAll( );
    }
	
	public Produto findById(Integer id) {
		return produtoRepository.findByCodigo( id );
	}

    public void inserir(Produto produto){
        produtoRepository.save( produto );
    	System.out.println("INSERIDO: " + produto);
    }

    public void alterar(Produto produto){
    	produtoRepository.save( produto );
    	System.out.println("ALTERADO: " + produto);
    }    

    public void excluir(Integer id){
    	Produto produto = produtoRepository.findByCodigo( id );
    	produtoRepository.delete( produto );
        System.out.println("EXCLUIDO: " + produto);
    }

    public Produto buscarTopByOrderByDataValidade(){
		Produto produto = produtoRepository.findTopByOrderByDataValidade();
		System.out.println("Produto: " + produto);
		return produto;
	}
}
