package com.abdiel.restauranteRest.RestauranteApp.mapper;

import com.abdiel.restauranteRest.RestauranteApp.dtos.response.ReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "observacao", ignore = true)
    ReservaDTO toDto(Reserva reserva);

    @Mapping(target = "codigo", ignore = true)
    Reserva toEntity(ReservaDTO reservaDTO);



    List<ReservaDTO> toDtoList(boolean reservas);

    List<ReservaDTO> converteListas(List<Reserva> reservas);
}
