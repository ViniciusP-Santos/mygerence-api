package com.vinicius.mygerenceapi.repositories;

import com.vinicius.mygerenceapi.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
