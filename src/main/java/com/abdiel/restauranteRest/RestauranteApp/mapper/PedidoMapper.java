package com.abdiel.restauranteRest.RestauranteApp.mapper;

import com.abdiel.restauranteRest.RestauranteApp.dtos.request.CriarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.PedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Pedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoDTO toDto(Pedido pedido);
    Pedido toEntity(PedidoDTO pedidoDTO);

    PedidoDTO delete(Long codigo);

    List<Pedido> toEntityList(List<CriarPedidoDTO> dtoList);

    List<PedidoDTO> converteList(List<Pedido> pedidosSalvos);

    List<PedidoDTO> converteListas(List<PedidoDTO> pedidos);
}
