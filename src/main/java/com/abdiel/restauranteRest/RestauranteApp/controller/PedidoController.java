package com.abdiel.restauranteRest.RestauranteApp.controller;

import com.abdiel.restauranteRest.RestauranteApp.dtos.request.CriarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.PedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/pedido")
public class PedidoController {
    private final PedidoService pedidoService;
    @GetMapping()
    public ResponseEntity<PedidoDTO> criaPedido(@RequestBody CriarPedidoDTO pedido) {
        PedidoDTO pedidoDTO = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(pedidoDTO);
    }
    @GetMapping("/codigo")
    public ResponseEntity<PedidoDTO> buscaPedido(@RequestParam Long codigo) {
        PedidoDTO pedidoDTO = pedidoService.buscaPedido(codigo);
        return ResponseEntity.ok(pedidoDTO);

    }

}
