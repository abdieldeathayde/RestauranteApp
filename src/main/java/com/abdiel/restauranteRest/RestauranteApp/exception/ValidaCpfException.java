package com.abdiel.restauranteRest.RestauranteApp.exception;

public class ValidaCpfException extends RuntimeException {
    public static final String CPF_NAO_ENCONTRADO = "CPF NÃO ESTÁ CADASTRADO!";

    public ValidaCpfException() {
        super(CPF_NAO_ENCONTRADO);
    }
}
