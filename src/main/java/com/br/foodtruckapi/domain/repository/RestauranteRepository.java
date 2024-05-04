package com.br.foodtruckapi.domain.repository;

import com.br.foodtruckapi.domain.model.Restaurante;

import javax.transaction.Transactional;
import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> todas();

    @Transactional
    Restaurante adcionar(Restaurante restaurante);

    Restaurante buscarPorId(Long id);

    Restaurante salvar(Restaurante restaurante);

    void remover (Restaurante restaurante);

}
