package com.bosonit.infrastructure.controller.dto;

import com.bosonit.domain.reserva.BackWebReservaCollection;
import lombok.Data;

import java.util.Date;

@Data
public class BackWebReservaOutputDTO {
    String ciudad;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;

    public BackWebReservaOutputDTO(BackWebReservaCollection backWebReservaCollection) {
        if (backWebReservaCollection == null) return;
        ciudad = backWebReservaCollection.getCiudad();
        nombre = backWebReservaCollection.getNombre();
        apellidos = backWebReservaCollection.getApellidos();
        telefono = backWebReservaCollection.getTelefono();
        fecha = backWebReservaCollection.getFecha();
    }
}