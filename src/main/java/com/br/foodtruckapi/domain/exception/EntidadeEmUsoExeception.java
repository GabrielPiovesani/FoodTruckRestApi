package com.br.foodtruckapi.domain.exception;

public class EntidadeEmUsoExeception extends RuntimeException{

    public EntidadeEmUsoExeception(String mensagem){
        super(mensagem);
    }
}
