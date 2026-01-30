package com.abdiel.restauranteRest.RestauranteApp.repository;

import com.abdiel.restauranteRest.RestauranteApp.dtos.response.ReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    void deleteByCodigo(Long codigo);
    List<ReservaDTO> findByCodigo(Long codigo);
}

