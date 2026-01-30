package com.abdiel.restauranteRest.RestauranteApp.repository;

import com.abdiel.restauranteRest.RestauranteApp.dtos.response.PedidoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.abdiel.restauranteRest.RestauranteApp.entities.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    void deleteByCodigo(Long codigo);
    List<PedidoDTO> findByCodigo(Long codigo);
}

