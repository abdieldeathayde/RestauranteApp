package com.abdiel.restauranteRest.RestauranteApp.controller;

import com.abdiel.restauranteRest.RestauranteApp.dtos.request.CriarReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.ReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaDTO> criaReserva(
            @RequestBody @Valid CriarReservaDTO reservaDTO) {

        ReservaDTO reservaCriada = reservaService.criarReserva(reservaDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservaCriada);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<List<ReservaDTO>> buscaReserva(@PathVariable Long codigo) {
        List<ReservaDTO> reservas = reservaService.listaReservas(codigo);

        if (reservas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<ReservaDTO>> buscarPorCpf(@PathVariable String cpf) {
        List<ReservaDTO> reservas = reservaService.buscaCpf(cpf);

        if (reservas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(reservas);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletaReserva(@PathVariable Long codigo) {
        reservaService.deletarReserva(codigo);
        return ResponseEntity.noContent().build();
    }
}
