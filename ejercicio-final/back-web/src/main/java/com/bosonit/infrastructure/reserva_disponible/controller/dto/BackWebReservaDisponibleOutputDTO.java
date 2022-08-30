package com.bosonit.infrastructure.reserva_disponible.controller.dto;

import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import lombok.Data;

import java.util.Date;

@Data
public class BackWebReservaDisponibleOutputDTO {
    String ciudad;
    Date fecha;
    Integer numeroPlazas;

    public BackWebReservaDisponibleOutputDTO(BackWebReservaDisponibleCollection backWebReservaDisponibleCollection) {
        if (backWebReservaDisponibleCollection == null) return;
        ciudad = backWebReservaDisponibleCollection.getCiudad();
        fecha = backWebReservaDisponibleCollection.getFecha();
        numeroPlazas = backWebReservaDisponibleCollection.getNumeroPlazas();
    }
}
