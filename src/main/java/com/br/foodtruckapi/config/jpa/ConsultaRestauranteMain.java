package com.br.foodtruckapi.config.jpa;

import com.br.foodtruckapi.FoodTruckApiApplication;
import com.br.foodtruckapi.domain.model.Cozinha;
import com.br.foodtruckapi.domain.model.Restaurante;
import com.br.foodtruckapi.domain.repository.CozinhaRepository;
import com.br.foodtruckapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(FoodTruckApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        RestauranteRepository cozinhas = applicationContext.getBean(RestauranteRepository.class);
        List<Restaurante> todasCozinhas = cozinhas.todas();

        for(Restaurante restaurante:todasCozinhas){
            System.out.printf("%s-%f-%s\n",restaurante.getNome(),restaurante.getTaxaFrete(),restaurante.getCozinha().getNome());
        }
    }
}
