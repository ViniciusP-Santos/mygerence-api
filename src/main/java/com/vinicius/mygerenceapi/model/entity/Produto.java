package com.vinicius.mygerenceapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME é requerido!")
    @Length(min = 3, max = 50, message = "Campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo MARCA é requerido!")
    @Length(min = 3, max = 50, message = "Campo MARCA deve ter entre 3 e 100 caracteres")
    private String marca;

    @NotEmpty(message = "Campo CONTEUDO é requerido!")
    @Length(min = 3, max = 50, message = "Campo CONTEUDO deve ter entre 3 e 100 caracteres")
    private String conteudo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Produto(){
        super();
    }

    public Produto(Integer id, String nome, String marca, String conteudo, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.conteudo = conteudo;
        this.categoria = categoria;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId(), produto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
