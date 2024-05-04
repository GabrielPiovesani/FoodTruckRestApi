package com.br.foodtruckapi.infrastructure.repository;

import com.br.foodtruckapi.domain.model.Restaurante;
import com.br.foodtruckapi.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> todas() {
        return manager.createQuery("from Restaurante",Restaurante.class)
                .getResultList();
    }

    @Transactional
    @Override
    public Restaurante adcionar(Restaurante restaurante){
        return manager.merge(restaurante);
    }

    @Override
    public Restaurante buscarPorId(Long id){
        return manager.find(Restaurante.class,id);
    }



    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    public void remover(Restaurante restaurante) {
    restaurante = buscarPorId(restaurante.getId());
    manager.remove(restaurante);
    }
}
