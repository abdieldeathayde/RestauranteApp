package com.abdiel.restauranteRest.RestauranteApp.controller;

import com.abdiel.restauranteRest.RestauranteApp.dtos.request.CriarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.PedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> criaPedido(@RequestBody @Valid CriarPedidoDTO pedido) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedidoService.criarPedido(pedido));
    }

    @PostMapping("/lote")
    public ResponseEntity<List<PedidoDTO>> cadastrarPedidos(
            @RequestBody @Valid List<CriarPedidoDTO> dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pedidoService.cadastrarPedidos(dto));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PedidoDTO> buscaPedido(@PathVariable Long codigo) {
        return ResponseEntity.ok(pedidoService.buscaPedido(codigo));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletaPedido(@PathVariable Long codigo) {
        pedidoService.deletarPedido(codigo);
        return ResponseEntity.noContent().build();
    }
}
