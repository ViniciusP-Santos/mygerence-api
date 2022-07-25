package com.vinicius.mygerenceapi.model.service;

import com.vinicius.mygerenceapi.model.entity.Produto;
import com.vinicius.mygerenceapi.model.service.exception.ObjectNotFoundException;
import com.vinicius.mygerenceapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepository repository;
    public Produto findById(Integer id){
        Optional<Produto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! ID: "+id+ " Tipo: "+Produto.class.getName()));
    }
}
