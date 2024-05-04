package com.br.foodtruckapi.domain.service;

import com.br.foodtruckapi.domain.exception.EntidadeEmUsoExeception;
import com.br.foodtruckapi.domain.exception.EntidadeNaoEncontradaExeception;
import com.br.foodtruckapi.domain.model.Cozinha;
import com.br.foodtruckapi.domain.repository.CozinhaRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;


    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.salvar(cozinha);
    }

    public void excluir(Long id){
        try {
            cozinhaRepository.remover(id);
        } catch (EmptyResultDataAccessException e){
            throw  new EntidadeNaoEncontradaExeception(
                    String.format("Não existe um cadastro de cozinha %d",id));

        } catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoExeception(
                    String.format("Cozinha de Codigo %d não pode ser removida,pois esta em uso",id));
        }


    }


}
