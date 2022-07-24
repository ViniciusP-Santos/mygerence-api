package com.vinicius.mygerenceapi;

import com.vinicius.mygerenceapi.model.entity.Produto;
import com.vinicius.mygerenceapi.model.entity.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MygerenceApiApplication{

    public static void main(String[] args) {
        SpringApplication.run(MygerenceApiApplication.class, args);
    }

}
