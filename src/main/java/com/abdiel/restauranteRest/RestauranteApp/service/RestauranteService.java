package com.abdiel.restauranteRest.RestauranteApp.service;

import com.abdiel.restauranteRest.RestauranteApp.dtos.AtualizaPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.CadastrarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.RestauranteDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Restaurante;
import com.abdiel.restauranteRest.RestauranteApp.mapper.RestauranteMapper;
import com.abdiel.restauranteRest.RestauranteApp.repository.RestauranteRepository;
import com.abdiel.restauranteRest.RestauranteApp.validador.RestauranteValidador;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;
    private final RestauranteValidador restauranteValidador;
    private final RestauranteMapper restauranteMapper;

    public RestauranteService(RestauranteRepository restauranteRepository, RestauranteValidador restauranteValidador, RestauranteMapper restauranteMapper) {
        this.restauranteRepository = restauranteRepository;
        this.restauranteMapper = restauranteMapper;
        this.restauranteValidador = restauranteValidador;
    }

    public RestauranteDTO salvarRestaurante(CadastrarPedidoDTO dto) {
        Restaurante restaurante = restauranteMapper.toEntity(dto);
        restauranteRepository.save(restaurante);
        return restauranteMapper.toDto(restaurante);
    }

    public Optional<RestauranteDTO> buscarPorNome(String nome) {
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

    public List<Restaurante> listarItens() {
        return List.of(
                new Restaurante(1L, "Pizza", 50.0),
                new Restaurante(2L, "Hambúrguer", 25.0),
                new Restaurante(3L, "Batata frita", 10.0),
                new Restaurante(4L, "X-Burguer", 8.5),
                new Restaurante(5L,"Coca-Cola", 9.0),
                new Restaurante(6L, "Guaraná", 8.0),
                new Restaurante(7L, "Fanta Uva", 7.0)

        );
    }

    public RestauranteDTO atualizarPedidoPorId(Integer id, AtualizaPedidoDTO dto) {
        Restaurante restaurante = restauranteValidador.validaSeIDPedidoExsiste(id);
        restauranteMapper.atualizaDto(dto, restaurante);
        restauranteRepository.save(restaurante);
        return restauranteMapper.toDto(restaurante);
    }

    public void deletarUsuarioPorNome(@NotBlank(message = "O campo nome é obrigatório.") String nome) {
        Restaurante restaurante = restauranteValidador.buscaPedidoRestaurante(nome);
        restauranteRepository.delete(restaurante);
    }
}

