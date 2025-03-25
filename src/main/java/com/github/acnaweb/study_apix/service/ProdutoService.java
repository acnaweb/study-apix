package com.github.acnaweb.study_apix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.acnaweb.study_apix.model.Produto;

@Service
public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();
    private Long id = 1L;

    public Produto save(Produto request) {
        request.setId(id++);
        produtos.add(request);        
        return request;
    }

}
