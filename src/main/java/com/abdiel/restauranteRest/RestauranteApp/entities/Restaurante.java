package com.abdiel.restauranteRest.RestauranteApp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;



@Table(name = "usuarios")
@Data
@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String pedido;
    private int mesa;
    private LocalDateTime dataPedido = LocalDateTime.now();

}