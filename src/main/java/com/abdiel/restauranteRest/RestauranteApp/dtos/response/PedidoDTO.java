package com.abdiel.restauranteRest.RestauranteApp.dtos.response;

import java.time.LocalDateTime;

public record PedidoDTO(
        Long codigo,
        int mesa,
        String nome,
        LocalDateTime data
) {
}
