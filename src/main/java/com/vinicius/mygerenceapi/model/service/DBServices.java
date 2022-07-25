package com.vinicius.mygerenceapi.model.service;

import com.vinicius.mygerenceapi.model.entity.Categoria;
import com.vinicius.mygerenceapi.model.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vinicius.mygerenceapi.repositories.CategoriaRepository;
import com.vinicius.mygerenceapi.repositories.ProdutoRepository;

import java.util.Arrays;

@Service
public class DBServices {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public void instanciaBD(){
        Categoria cat1 = new Categoria(null, "Hardware", "Produtos fisicos");
        Produto p1 = new Produto(null, "Mouse","Hoopson","Mouse USB",cat1);

        cat1.getProdutos().addAll(Arrays.asList(p1));


        //Salvando todos os dados no banco de dados através do JPA Repository
        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.produtoRepository.saveAll(Arrays.asList(p1));
    }
}
