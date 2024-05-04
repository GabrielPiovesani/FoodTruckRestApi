package com.br.foodtruckapi.config.jpa;

import com.br.foodtruckapi.FoodTruckApiApplication;
import com.br.foodtruckapi.domain.model.Cozinha;
import com.br.foodtruckapi.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FoodTruckApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
        List<Cozinha> todasCozinhas = cozinhas.todas();

        for(Cozinha cozinha:todasCozinhas){
            System.out.println(cozinha.getNome());
        }
    }
}
