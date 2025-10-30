package com.abdiel.restauranteRest.RestauranteApp.controller;

import com.abdiel.restauranteRest.RestauranteApp.dtos.AtualizaPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.CadastrarPedidoDTO;
import com.abdiel.restauranteRest.RestauranteApp.dtos.response.RestauranteDTO;
import com.abdiel.restauranteRest.RestauranteApp.entities.Restaurante;
import com.abdiel.restauranteRest.RestauranteApp.service.RestauranteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "cardapio")
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping
    public ResponseEntity<RestauranteDTO> cadastrarRestaurante(
            @RequestBody CadastrarPedidoDTO dto
    ) {
        RestauranteDTO novoRestaurante = restauranteService.salvarRestaurante(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoRestaurante);
    }

    @GetMapping("/buscar")
    public ResponseEntity<RestauranteDTO> buscarPorNome(@RequestParam String nome) {
        return restauranteService.buscarPorNome(nome)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Listar todos os itens do menu")
    public List<Restaurante> listarMenu() {
        return restauranteService.listarItens();
    }

    @PostMapping("/cadastrarPedidos")
    public ResponseEntity<List<RestauranteDTO>> salvarPedidos(@RequestBody @Valid List<CadastrarPedidoDTO> dto) {
        List<RestauranteDTO> pedidosCadastrados = restauranteService.salvarPedidos(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidosCadastrados);
    }

    @DeleteMapping
    public ResponseEntity<String> deletarPedidoPorNome(
            @RequestParam @NotBlank(message = "O campo nome é obrigatório.") String nome) {
        restauranteService.deletarUsuarioPorNome(nome);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pedido deletado com sucesso.");
    }

    @PutMapping
    public ResponseEntity<RestauranteDTO> atualizarUsuarioPorId(Integer id, AtualizaPedidoDTO dto) {
        RestauranteDTO restauranteDTO = restauranteService.atualizarPedidoPorId(id, dto);
        return ResponseEntity.ok(restauranteDTO);
    }

}

