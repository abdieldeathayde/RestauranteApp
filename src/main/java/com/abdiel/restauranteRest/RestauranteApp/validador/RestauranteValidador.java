package com.abdiel.restauranteRest.RestauranteApp.validador;

import com.abdiel.restauranteRest.RestauranteApp.entities.Restaurante;
import com.abdiel.restauranteRest.RestauranteApp.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

@Component
public class RestauranteValidador {
    private final RestauranteRepository restauranteRepository;

    public RestauranteValidador(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Restaurante buscaPedidoRestaurante(String pedido) {
        return restauranteRepository.findByPedido(pedido).orElseThrow();
    }

    public Restaurante buscaRestaurante(String restaurante) {
        return restauranteRepository.findByNome(restaurante).orElseThrow();
    }

}
