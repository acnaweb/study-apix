package com.github.acnaweb.study_apix.dto;

import com.github.acnaweb.study_apix.model.Produto;

public class ProdutoResponse {
    private Long id;    
    private String nome;

    public ProdutoResponse toDto(Produto produto) {
        this.setId(produto.getId());
        this.setNome(produto.getNome());
        return this;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
