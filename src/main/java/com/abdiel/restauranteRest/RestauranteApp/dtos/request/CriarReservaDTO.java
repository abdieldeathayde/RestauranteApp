package com.abdiel.restauranteRest.RestauranteApp.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CriarReservaDTO(
        @NotBlank(message = "Campo nome é obrigatório")
        String nome,
        @NotBlank(message = "Campo CPF é obrigatório")
        String cpf,
        @NotNull(message = "Campo qtdPessoas é obrigatório")
        @Positive(message = "quantidade de pessoas deve ser maior que zero")
        Integer qtdPessoas,

        String Obs


) {}
