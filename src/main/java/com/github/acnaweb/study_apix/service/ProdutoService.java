package com.github.acnaweb.study_apix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apix.dto.ProdutoRequestCreate;
import com.github.acnaweb.study_apix.model.Produto;
import com.github.acnaweb.study_apix.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(ProdutoRequestCreate dto) {
                
        Produto produto = new Produto();
        produto.setNome(dto.getNome());

        return produtoRepository.save(produto);
    }

}
