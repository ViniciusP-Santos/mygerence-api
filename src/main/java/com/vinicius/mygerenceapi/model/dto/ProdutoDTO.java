package com.vinicius.mygerenceapi.model.dto;

import com.vinicius.mygerenceapi.model.entity.Produto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {

    private Integer id;
    private String nome;

    public ProdutoDTO() {
        super();
    }

    public ProdutoDTO(Produto obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
