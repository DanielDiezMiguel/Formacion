package com.bosonit.infrastructure.reserva_disponible.controller.dto;

import com.bosonit.domain.reserva_disponible.BackEmpresaReservaDisponibleCollection;
import lombok.Data;

import java.util.Date;

@Data
public class BackEmpresaReservaDisponibleOutputDTO {
    String ciudad;
    Date fecha;
    Integer numeroPlazas;

    public BackEmpresaReservaDisponibleOutputDTO(BackEmpresaReservaDisponibleCollection backEmpresaReservaDisponibleCollection) {
        if (backEmpresaReservaDisponibleCollection == null) return;
        ciudad = backEmpresaReservaDisponibleCollection.getCiudad();
        fecha = backEmpresaReservaDisponibleCollection.getFecha();
        numeroPlazas = backEmpresaReservaDisponibleCollection.getNumeroPlazas();
    }
}
