package com.br.foodtruckapi.config.jpa;

import com.br.foodtruckapi.FoodTruckApiApplication;
import com.br.foodtruckapi.domain.model.Cozinha;
import com.br.foodtruckapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class AlteracaoCozinhaMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FoodTruckApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setNome("Brasileira");
        cozinha.setId(1L);

        cadastroCozinha.adcionar(cozinha);


        }
    }

