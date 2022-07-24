package com.vinicius.mygerenceapi;

import com.vinicius.mygerenceapi.model.entity.Produto;
import com.vinicius.mygerenceapi.model.entity.Categoria;
import com.vinicius.mygerenceapi.repositories.CategoriaRepository;
import com.vinicius.mygerenceapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MygerenceApiApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public static void main(String[] args) {
        SpringApplication.run(MygerenceApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Hardware", "Produtos fisicos");
        Produto p1 = new Produto(null, "Mouse","Hoopson","Mouse USB",cat1);

        cat1.getProdutos().addAll(Arrays.asList(p1));


        //Salvando todos os dados no banco de dados através do JPA Repository
        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.produtoRepository.saveAll(Arrays.asList(p1));
    }
}
