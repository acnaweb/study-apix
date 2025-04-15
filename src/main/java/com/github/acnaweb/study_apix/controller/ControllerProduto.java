package com.github.acnaweb.study_apix.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_apix.dto.ProdutoRequestCreate;
import com.github.acnaweb.study_apix.dto.ProdutoRequestUpdate;
import com.github.acnaweb.study_apix.dto.ProdutoResponse;
import com.github.acnaweb.study_apix.model.Produto;
import com.github.acnaweb.study_apix.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ControllerProduto {

    @Autowired
    private ProdutoService produtoService;


    
    @PostMapping
    public ResponseEntity<Produto> 
                create(@RequestBody ProdutoRequestCreate dto) {

        Produto produto = produtoService.save(dto);

        return ResponseEntity.status(201).body(produto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponse> update(
				@PathVariable Long id, 
				@RequestBody ProdutoRequestUpdate dto) {
               
        return produtoService.update(id, dto)
                    .map(produto -> {
                        ProdutoResponse response = new ProdutoResponse();
                        response.setId(produto.getId());
                        response.setNome(produto.getNome());
                        return ResponseEntity.status(200).body(response);
                    })                  
                    .orElse(ResponseEntity.notFound().build());        
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = produtoService.findAll();        
        return ResponseEntity.status(200).body(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {         
        return produtoService.findById(id)
            .map(p -> ResponseEntity.ok(p))
            .orElse(ResponseEntity.notFound().build());        
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = produtoService.deleteById(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }        
    }

}
