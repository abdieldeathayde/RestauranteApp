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
    private double valor;
    private long mesa;
    private LocalDateTime dataPedido = LocalDateTime.now();

    public Restaurante(long mesa, String pedido, double valor) {
        this.mesa = mesa;
        this.pedido = pedido;
        this.valor = valor;
    }
}