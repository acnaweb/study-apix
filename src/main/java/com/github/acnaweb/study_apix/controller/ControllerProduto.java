package com.github.acnaweb.study_apix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_apix.model.Produto;
import com.github.acnaweb.study_apix.service.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ControllerProduto {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto request) {

        Produto produto = produtoService.save(request);

        return ResponseEntity.status(201).body(produto);
    }

    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.status(200).body("Produto atualizado");
    }

    @GetMapping
    public ResponseEntity<String> find() {
        return ResponseEntity.status(200).body("uva");
    }

    @DeleteMapping
    public ResponseEntity<Void> delete() {
        return ResponseEntity.status(204).build();
    }

}
