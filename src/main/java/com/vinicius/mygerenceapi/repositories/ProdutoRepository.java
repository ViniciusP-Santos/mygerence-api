package com.vinicius.mygerenceapi.repositories;

import com.vinicius.mygerenceapi.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Query("SELECT obj FROM Produto obj WHERE obj.categoria.id = :id_cat ORDER BY nome")
    List<Produto> findAllByCategoria(@Param(value="id_cat") Integer id_cat);
}
