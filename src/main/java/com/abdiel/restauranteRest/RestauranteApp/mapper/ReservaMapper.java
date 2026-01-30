package com.abdiel.restauranteRest.RestauranteApp.mapper;

import com.abdiel.restauranteRest.RestauranteApp.dtos.request.CriarReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.ReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    @Mapping(target = "observacao", ignore=true)
    ReservaDTO toDto(Reserva reserva);
    @Mapping(target = "observacao", ignore = true)
    Reserva toEntity(ReservaDTO reservaDTO);

    ReservaDTO delete(Long codigo);

    List<Reserva> toEntityList(List<CriarReservaDTO> dtoList);

    List<ReservaDTO> converteList(List<Reserva> pedidosSalvos);

    List<ReservaDTO> converteListas(List<ReservaDTO> pedidos);
}
