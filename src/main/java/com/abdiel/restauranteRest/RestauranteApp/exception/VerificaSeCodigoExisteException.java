package com.abdiel.restauranteRest.RestauranteApp.exception;

public class VerificaSeCodigoExisteException extends RuntimeException {
    private static final String ValidaCodigo = "CODIGO NÃO ENCONTRADO";

    public VerificaRestauranteException() {
        super(ValidaCodigo);
    }
}
