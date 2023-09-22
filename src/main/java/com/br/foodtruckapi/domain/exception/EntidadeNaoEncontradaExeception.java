package com.br.foodtruckapi.domain.exception;

public class EntidadeNaoEncontradaExeception extends RuntimeException{

    public EntidadeNaoEncontradaExeception(String mensagem){
        super(mensagem);
    }
}
