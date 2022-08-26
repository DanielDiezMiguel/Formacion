package com.bosonit.infrastructure.controller.dto;

import com.bosonit.domain.BackWebReservaEntity;
import lombok.Data;

import java.util.Date;

@Data
public class BackWebReservaOutputDTO {
    String id_persona;
    String ciudad_destino;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;

    public BackWebReservaOutputDTO(BackWebReservaEntity backWebReservaEntity) {
        if (backWebReservaEntity == null) return;
        id_persona = backWebReservaEntity.getId_persona();
        ciudad_destino = backWebReservaEntity.getCiudad_destino();
        nombre = backWebReservaEntity.getNombre();
        apellidos = backWebReservaEntity.getApellidos();
        telefono = backWebReservaEntity.getTelefono();
        fecha = backWebReservaEntity.getFecha();
    }
}