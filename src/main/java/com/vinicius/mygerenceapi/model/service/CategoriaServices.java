package com.vinicius.mygerenceapi.model.service;

import com.vinicius.mygerenceapi.model.entity.Categoria;
import com.vinicius.mygerenceapi.model.service.exception.ObjectNotFoundException;
import com.vinicius.mygerenceapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);

        //Tratando a excessão, caso a categoria não exista
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+ id + ", Tipo: "+Categoria.class.getName()));
    }
}
