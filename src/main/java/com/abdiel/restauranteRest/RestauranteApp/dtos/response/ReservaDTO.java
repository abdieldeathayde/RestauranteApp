package com.abdiel.restauranteRest.RestauranteApp.dtos.response;

import com.abdiel.restauranteRest.RestauranteApp.entities.ReservaStatus;

import java.time.LocalDateTime;

public record ReservaDTO(
        String nome,
        String cpf,
        Integer mesa,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao,
        ReservaStatus status,
        Integer qtdPessoas,
        String observacao

) {
}
