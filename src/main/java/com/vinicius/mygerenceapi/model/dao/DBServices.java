package com.vinicius.mygerenceapi.model.dao;

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
        Categoria cat1 = new Categoria(null, "Hardwares", "Produtos fisicos");
        Categoria cat2 = new Categoria(null, "Softwares", "Produtos Logicos");
        Produto p1 = new Produto(null, "Mouse","Hoopson","Mouse USB",cat1);
        Produto p2 = new Produto(null, "Teclado","Dell","Teclado Bluetooth",cat1);
        Produto p3 = new Produto(null, "Photoshop","Adobe","Photoshop CC 2022",cat2);

        cat1.getProdutos().addAll(Arrays.asList(p1));


        //Salvando todos os dados no banco de dados através do JPA Repository
        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.produtoRepository.saveAll(Arrays.asList(p1));
        this.categoriaRepository.saveAll(Arrays.asList(cat2));
        this.produtoRepository.saveAll(Arrays.asList(p2));
        this.produtoRepository.saveAll(Arrays.asList(p3));
    }
}
