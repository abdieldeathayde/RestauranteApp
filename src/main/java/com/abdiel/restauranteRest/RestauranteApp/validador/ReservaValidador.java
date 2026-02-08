package com.abdiel.restauranteRest.RestauranteApp.validador;

import com.abdiel.restauranteRest.RestauranteApp.entities.Reserva;
import com.abdiel.restauranteRest.RestauranteApp.exception.ValidaCpfException;
import com.abdiel.restauranteRest.RestauranteApp.exception.VerificaRestauranteException;
import com.abdiel.restauranteRest.RestauranteApp.exception.VerificaSeCodigoExisteException;
import com.abdiel.restauranteRest.RestauranteApp.repository.ReservaRepository;

public class ReservaValidador {

    ReservaRepository reservaRepository;
    ReservaValidador reservaValidador;
    ValidaCpfException validaCpfException;
    VerificaRestauranteException verificaRestauranteException;

    public ReservaValidador(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public void validaCPF(String cpf) {
        if (reservaRepository.findByCPF(cpf)){
           throw new ValidaCpfException();
        }
    }

    public void existsByCodigo (Long codigo) {
        if (reservaRepository.existsByCodigo(codigo)) {
            throw new VerificaSeCodigoExisteException();
        }
    }

}
