package com.vinicius.mygerenceapi.controller;

import com.vinicius.mygerenceapi.model.dto.ProdutoDTO;
import com.vinicius.mygerenceapi.model.entity.Produto;
import com.vinicius.mygerenceapi.model.dao.impl.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoDAO service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
        //localhost:8080/produtos?categoria=1
        List<Produto> list = service.findAll(id_cat);
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
