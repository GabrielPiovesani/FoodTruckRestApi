package com.br.foodtruckapi.config.jpa;

import com.br.foodtruckapi.FoodTruckApiApplication;
import com.br.foodtruckapi.domain.model.Cozinha;
import com.br.foodtruckapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class InclusaoCozinhaMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FoodTruckApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Brasileira");

        Cozinha cozinha2= new Cozinha();
        cozinha2.setNome("Japonesa");

        cadastroCozinha.adcionar(cozinha1);
        cadastroCozinha.adcionar(cozinha2);

        }
    }

