package com.abdiel.restauranteRest.RestauranteApp.repository;

import com.abdiel.restauranteRest.RestauranteApp.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    Optional<Restaurante> findByPedido(String pedido);
    Optional<Restaurante> findByNome(String nome);
}
