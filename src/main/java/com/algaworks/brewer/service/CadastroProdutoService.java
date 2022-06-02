package com.algaworks.brewer.service;

import com.algaworks.brewer.model.Produto;
import com.algaworks.brewer.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public void salvar(Produto produto){
        produtoRepository.save(produto);
    }
}
