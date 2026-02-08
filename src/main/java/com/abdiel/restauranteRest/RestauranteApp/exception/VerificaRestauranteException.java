package com.abdiel.restauranteRest.RestauranteApp.exception;

public class VerificaRestauranteException extends RuntimeException {

    private static final String RESTAURANTE = "Restaurante não encontrado";

    public VerificaRestauranteException() {
        super(RESTAURANTE);
    }
}
