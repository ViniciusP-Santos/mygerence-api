package com.vinicius.mygerenceapi.controller;

import com.vinicius.mygerenceapi.model.dto.ProdutoDTO;
import com.vinicius.mygerenceapi.model.entity.Produto;
import com.vinicius.mygerenceapi.model.dao.impl.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoDAO service;

    //Metodo para Listar produtos por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    //Metodo para listar produtos por categoria
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
        List<Produto> list = service.findAll(id_cat);
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }


    //Metodo utilizado quando for atualizar varios dados de um Produto
    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @Valid @RequestBody Produto obj){
        Produto newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }


    //Metodo utilizado quando for atualizar somente um dado do Produto
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Produto> updatePatch(@PathVariable Integer id,@Valid @RequestBody Produto obj){
        Produto newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Produto> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat, @Valid @RequestBody Produto obj){
        Produto newObj = service.create(id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produtos/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);

        return ResponseEntity.noContent().build();

    }
}
