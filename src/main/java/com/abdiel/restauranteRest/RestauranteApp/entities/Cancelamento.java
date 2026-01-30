package com.abdiel.restauranteRest.RestauranteApp.entities;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class Cancelamento {

    @Column(nullable = false)
    private Long codigo;

    @Column(nullable = false)
    private String nomeSolicitante;

    @Column(nullable = false)
    private LocalDateTime dataCancelamento;

    @Column(nullable = false)
    private String motivoCancelamento;
}
