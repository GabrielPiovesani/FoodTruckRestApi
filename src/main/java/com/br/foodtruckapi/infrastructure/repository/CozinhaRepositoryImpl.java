package com.br.foodtruckapi.infrastructure.repository;

import com.br.foodtruckapi.domain.model.Cozinha;
import com.br.foodtruckapi.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> todas() {
        return manager.createQuery("from Cozinha",Cozinha.class)
                .getResultList();
    }

    @Transactional
    @Override
    public Cozinha adcionar(Cozinha cozinha){
        return manager.merge(cozinha);
    }

    @Override
    public Cozinha buscarPorId(Long id){
        return manager.find(Cozinha.class,id);
    }

    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    public void remover(Cozinha cozinha) {
    cozinha = buscarPorId(cozinha.getId());
    manager.remove(cozinha);
    }
}
