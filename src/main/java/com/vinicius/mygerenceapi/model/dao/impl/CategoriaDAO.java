package com.vinicius.mygerenceapi.model.dao.impl;

import com.vinicius.mygerenceapi.model.dto.CategoriaDTO;
import com.vinicius.mygerenceapi.model.entity.Categoria;
import com.vinicius.mygerenceapi.model.dao.exception.ObjectNotFoundException;
import com.vinicius.mygerenceapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaDAO {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);

        //Tratando a excessão, caso a categoria não exista
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: Categoria "+ id + ", Tipo: "+Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new com.vinicius.mygerenceapi.model.dao.exception.DataIntegrityViolationException(
                    "Categoria não pode ser deletada! Possui produtos associados.");
        }
    }
}
