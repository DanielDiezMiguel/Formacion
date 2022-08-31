package com.bosonit.infrastructure.controller.dto;

import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import lombok.Data;

import java.util.Date;

@Data
public class BackEmpresaReservaOutputDTO {
    String id_persona;
    String ciudad_destino;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;

    public BackEmpresaReservaOutputDTO(BackEmpresaReservaCollection backEmpresaReservaCollection) {
        if (backEmpresaReservaCollection == null) return;
        id_persona = backEmpresaReservaCollection.getId_persona();
        ciudad_destino = backEmpresaReservaCollection.getCiudad_destino();
        nombre = backEmpresaReservaCollection.getNombre();
        apellidos = backEmpresaReservaCollection.getApellidos();
        telefono = backEmpresaReservaCollection.getTelefono();
        fecha = backEmpresaReservaCollection.getFecha();
    }
}
