package com.abdiel.restauranteRest.RestauranteApp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarPedidoDTO(
        @NotBlank(message = "O campo nome é obrigatório")
        String nome,
        @NotBlank(message = "O campo pedido é obrigatório")
        String pedido,
        @NotNull(message = "O campo mesa é obrigatório")
        int mesa) {

}
