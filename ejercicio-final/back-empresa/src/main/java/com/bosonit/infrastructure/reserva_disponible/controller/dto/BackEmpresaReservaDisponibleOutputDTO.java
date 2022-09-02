package com.bosonit.infrastructure.reserva_disponible.controller.dto;

import com.bosonit.domain.reserva_disponible.BackEmpresaReservaDisponibleCollection;
import lombok.Data;

import java.util.Date;

@Data
public class BackEmpresaReservaDisponibleOutputDTO {
    String id_reserva_disponible;
    String ciudad;
    Date fecha;
    Integer numeroPlazas;

    public BackEmpresaReservaDisponibleOutputDTO(BackEmpresaReservaDisponibleCollection backEmpresaReservaDisponibleCollection) {
        if (backEmpresaReservaDisponibleCollection == null) return;
        id_reserva_disponible = backEmpresaReservaDisponibleCollection.getId_reserva_disponible();
        ciudad = backEmpresaReservaDisponibleCollection.getCiudad();
        fecha = backEmpresaReservaDisponibleCollection.getFecha();
        numeroPlazas = backEmpresaReservaDisponibleCollection.getNumeroPlazas();
    }
}
