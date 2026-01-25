package com.abdiel.restauranteRest.RestauranteApp.mapper;

import com.abdiel.restauranteRest.RestauranteApp.dtos.response.PedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Pedido;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoDTO toDto(Pedido pedido);
    Pedido toEntity(PedidoDTO pedidoDTO);

}
