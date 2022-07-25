package com.vinicius.mygerenceapi.controller;

import com.vinicius.mygerenceapi.model.entity.Produto;
import com.vinicius.mygerenceapi.model.service.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServices service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id){
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
