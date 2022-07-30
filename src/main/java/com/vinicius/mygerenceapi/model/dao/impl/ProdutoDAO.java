package com.vinicius.mygerenceapi.model.dao.impl;

import com.vinicius.mygerenceapi.model.entity.Categoria;
import com.vinicius.mygerenceapi.model.entity.Produto;
import com.vinicius.mygerenceapi.model.dao.exception.ObjectNotFoundException;
import com.vinicius.mygerenceapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
                "Objeto não encontrado! ID: Produto"+id+ " Tipo: "+Produto.class.getName()));
    }



    public List<Produto> findAll(Integer id_cat) {
        //Validando se essa categoria realmente existe na base de dados
        categoriaDAO.findById(id_cat);
        return repository.findAllByCategoria(id_cat);
    }

    public Produto update(Integer id, Produto obj) {
        Produto newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Produto newObj, Produto obj) {
        newObj.setNome(obj.getNome());
        newObj.setConteudo(obj.getConteudo());
        newObj.setMarca(obj.getMarca());
    }

    public Produto create(Integer id_cat, Produto obj) {
        obj.setId(null);
        //Verificando se categoria existe na base de dados
        Categoria cat = categoriaDAO.findById(id_cat);
        //fazendo com que o obj conheça sua categoria
        obj.setCategoria(cat);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        //Verificando se o Produto existe
        Produto obj = findById(id);

        repository.delete(obj);
    }
}
