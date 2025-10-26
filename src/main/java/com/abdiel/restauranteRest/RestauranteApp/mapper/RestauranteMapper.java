package com.abdiel.restauranteRest.RestauranteApp.mapper;

import com.abdiel.restauranteRest.RestauranteApp.dtos.CadastrarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.RestauranteDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Restaurante;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    List<Restaurante> toEntityList(List<CadastrarPedidoDTO> dtoList);

    List<RestauranteDTO> converteLista(List<Restaurante> entity);
}
