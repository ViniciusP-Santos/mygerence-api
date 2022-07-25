package com.vinicius.mygerenceapi.model.dao.impl;

import com.vinicius.mygerenceapi.model.entity.Categoria;
import com.vinicius.mygerenceapi.model.entity.Produto;
import com.vinicius.mygerenceapi.model.dao.exception.ObjectNotFoundException;
import com.vinicius.mygerenceapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoDAO {

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Autowired
    private ProdutoRepository repository;
    public Produto findById(Integer id){
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: "+id+ " Tipo: "+Produto.class.getName()));
    }



    public List<Produto> findAll(Integer id_cat) {
        //Validando se essa categoria realmente existe na base de dados
        categoriaDAO.findById(id_cat);
        return repository.findAllByCategoria(id_cat);
    }
}
