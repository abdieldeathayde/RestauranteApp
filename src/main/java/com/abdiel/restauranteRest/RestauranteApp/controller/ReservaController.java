package com.abdiel.restauranteRest.RestauranteApp.controller;

import com.abdiel.restauranteRest.RestauranteApp.dtos.request.CriarReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.ReservaDTO;
import com.abdiel.restauranteRest.RestauranteApp.service.ReservaService;
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
    public ResponseEntity<ReservaDTO> criaReserva(@RequestBody CriarReservaDTO pedido) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservaService.criarReserva(pedido));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<List<ReservaDTO>> buscaReserva(@PathVariable Long codigo) {
        List<ReservaDTO> listaReserva = reservaService.listaReservas(codigo);
        return ResponseEntity.ok(listaReserva);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletaReserva(@PathVariable Long codigo) {
        reservaService.deletarReserva(codigo);
        return ResponseEntity.noContent().build();
    }
}
