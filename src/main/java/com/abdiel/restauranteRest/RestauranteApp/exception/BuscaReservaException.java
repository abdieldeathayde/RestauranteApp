package com.abdiel.restauranteRest.RestauranteApp.exception;

public class BuscaReservaException extends RuntimeException {

    private static final String BUSCA_PEDIDO = "RESERVA NÃO ENCONTRADA";

    public BuscaReservaException() {
        super(BUSCA_PEDIDO);
    }




}
