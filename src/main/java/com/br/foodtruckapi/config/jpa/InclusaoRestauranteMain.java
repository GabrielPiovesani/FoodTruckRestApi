package com.br.foodtruckapi.config.jpa;

import com.br.foodtruckapi.FoodTruckApiApplication;
import com.br.foodtruckapi.domain.model.Cozinha;
import com.br.foodtruckapi.domain.model.Restaurante;
import com.br.foodtruckapi.domain.repository.CozinhaRepository;
import com.br.foodtruckapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FoodTruckApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        RestauranteRepository cadastroCozinha = applicationContext.getBean(RestauranteRepository.class);
        Restaurante cozinha1 = new Restaurante();
        cozinha1.setNome("Lanchonete do seu ze");
        cozinha1.setTaxaFrete(BigDecimal.valueOf(1.0));

        cadastroCozinha.adcionar(cozinha1);


        }
    }

