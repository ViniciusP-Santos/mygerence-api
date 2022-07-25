package com.vinicius.mygerenceapi.config;

import com.vinicius.mygerenceapi.model.service.DBServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBServices dbServices;

    @Bean
    public void instanciaBD(){
        this.dbServices.instanciaBD();
    }
}
