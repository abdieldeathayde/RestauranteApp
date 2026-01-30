package com.abdiel.restauranteRest.RestauranteApp.service;

import com.abdiel.restauranteRest.RestauranteApp.dtos.request.CriarReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.ReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Reserva;
import com.abdiel.restauranteRest.RestauranteApp.entities.ReservaStatus;
import com.abdiel.restauranteRest.RestauranteApp.mapper.ReservaMapper;
import com.abdiel.restauranteRest.RestauranteApp.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    public ReservaDTO criarReserva(CriarReservaDTO reserva) {
        ReservaDTO reservaDTO = new ReservaDTO(
                reserva.nome(),
                reserva.cpf(),
                2,
                LocalDateTime.now(),
                null,
                ReservaStatus.CRIADA,
                reserva.qtdPessoas(),
                reserva.Obs()
        );
        Reserva result = reservaRepository.save(reservaMapper.toEntity(reservaDTO));
        return reservaMapper.toDto(result);
    }
    @Transactional
    public void deletarReserva(Long codigo) {
        reservaRepository.deleteByCodigo(codigo);
    }

    public List<ReservaDTO> listaReservas(Long codigo) {
        List<ReservaDTO> reservas = reservaRepository.findByCodigo(codigo);
        return reservaMapper.converteListas(reservas);
    }
}
