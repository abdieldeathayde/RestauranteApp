package com.abdiel.restauranteRest.RestauranteApp.exception;

public class ValidaRestauranteException extends RuntimeException {
    public static final String BUSCA_CPF = "CPF JÁ EXISTE!";

    public ValidaRestauranteException() {
        super(BUSCA_CPF);
    }

}
