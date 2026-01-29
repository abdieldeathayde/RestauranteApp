package com.abdiel.restauranteRest.RestauranteApp.repository;

import com.abdiel.restauranteRest.RestauranteApp.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Pedido findByCodigo(Long codigo);
    void deleteByCodigo(Long codigo);
}

