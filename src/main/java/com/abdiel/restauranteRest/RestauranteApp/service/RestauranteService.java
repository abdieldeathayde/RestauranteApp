package com.abdiel.restauranteRest.RestauranteApp.service;

import com.abdiel.restauranteRest.RestauranteApp.dtos.CadastrarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.RestauranteDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Restaurante;
import com.abdiel.restauranteRest.RestauranteApp.mapper.RestauranteMapper;
import com.abdiel.restauranteRest.RestauranteApp.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;
    private final RestauranteMapper restauranteMapper;

    public RestauranteService(RestauranteRepository restauranteRepository, RestauranteMapper restauranteMapper) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteMapper = restauranteMapper;
    }

    public Restaurante salvarRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Optional<Restaurante> buscarPorNome(String nome) {
        return restauranteRepository.findByNome(nome);
    }

    public List<RestauranteDTO> salvarPedidos(List<CadastrarPedidoDTO> dtoList) {
        List<Restaurante> pedidos = restauranteMapper.toEntityList(dtoList);

        List<Restaurante> pedidosCadastrados = restauranteRepository.saveAll(pedidos);

        return restauranteMapper.converteLista(pedidosCadastrados);
    }


    public Optional<Restaurante> buscarPorPedido(String pedido) {
        return restauranteRepository.findByPedido(pedido);
    }
}

