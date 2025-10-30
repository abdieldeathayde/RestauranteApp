package com.abdiel.restauranteRest.RestauranteApp.mapper;

import com.abdiel.restauranteRest.RestauranteApp.dtos.AtualizaPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.CadastrarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.RestauranteDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Restaurante;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    List<Restaurante> saveAll(List<Restaurante> pedidos);

    RestauranteDTO toDto(Restaurante entity);

    List<Restaurante> toEntityList(List<CadastrarPedidoDTO> dtoList);

    Restaurante toEntity(CadastrarPedidoDTO dto);

    Restaurante atualizaDto(AtualizaPedidoDTO dto, @MappingTarget Restaurante entity);

    List<RestauranteDTO> converteLista(List<Restaurante> entity);

}
