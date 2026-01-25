package com.abdiel.restauranteRest.RestauranteApp.service;

import com.abdiel.restauranteRest.RestauranteApp.dtos.request.CriarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.PedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Pedido;
import com.abdiel.restauranteRest.RestauranteApp.mapper.PedidoMapper;
import com.abdiel.restauranteRest.RestauranteApp.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;


    public PedidoDTO criarPedido(CriarPedidoDTO pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO(
                1,
                2,
                pedido.nome(),
                LocalDateTime.now()
        );

        Pedido result = pedidoRepository.save(pedidoMapper.toEntity(pedidoDTO));
        return pedidoMapper.toDto(result);
    }

    public PedidoDTO buscaPedido(Long codigo) {
        Pedido result = pedidoRepository.findByCodigo(codigo);
        return pedidoMapper.toDto(result);
    }

}
