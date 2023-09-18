package com.br.foodtruckapi.config.jpa;

import com.br.foodtruckapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroCozinha {
    @PersistenceContext
    private EntityManager manager;


    public List<Cozinha> listar() {
     return manager.createQuery("from Cozinha",Cozinha.class)
             .getResultList();
    }

    @Transactional
    public Cozinha adcionar(Cozinha cozinha){
        return manager.merge(cozinha);
    }

    public Cozinha buscar(Long id){
        return manager.find(Cozinha.class,id);
    }



}
