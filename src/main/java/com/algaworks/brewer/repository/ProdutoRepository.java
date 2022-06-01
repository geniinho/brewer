package com.algaworks.brewer.repository;

import com.algaworks.brewer.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
