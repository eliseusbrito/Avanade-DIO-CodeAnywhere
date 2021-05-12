package com.avanade.dio.api.controllers;

import org.springframework.http.HttpStatus;

import com.avanade.dio.api.services.EstoqueService;

import java.util.List;

import com.avanade.dio.api.models.Estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/itens")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;
    
    @GetMapping
    public List<Estoque> listar(){
        return estoqueService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void inserir(@RequestBody Estoque estoque){
        estoqueService.inserir(estoque);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void alterar(@RequestBody Estoque estoque){
        estoqueService.alterar(estoque);
    }

    @DeleteMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void excluir(@PathVariable Long id){
        estoqueService.excluir(id);
    }       
}