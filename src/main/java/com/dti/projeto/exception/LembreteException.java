package com.dti.projeto.exception;

//Classe para criar exceções com as proprias regras do projeto
public class LembreteException extends RuntimeException{

    public LembreteException(String msg){
        super(msg);
    }
}
