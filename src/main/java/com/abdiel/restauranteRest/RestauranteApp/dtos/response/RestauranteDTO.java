package com.abdiel.restauranteRest.RestauranteApp.dtos.response;

public record RestauranteDTO(
        Integer id,
        String nome,
        String pedido,
        int mesa,
        int valor) {
}
