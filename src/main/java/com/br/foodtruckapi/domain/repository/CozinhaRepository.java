package com.br.foodtruckapi.domain.repository;

import com.br.foodtruckapi.domain.model.Cozinha;

import javax.transaction.Transactional;
import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> todas();

    @Transactional
    Cozinha adcionar(Cozinha cozinha);

    Cozinha buscarPorId(Long id);

    Cozinha salvar(Cozinha cozinha);

    void remover (Cozinha cozinha);

}
