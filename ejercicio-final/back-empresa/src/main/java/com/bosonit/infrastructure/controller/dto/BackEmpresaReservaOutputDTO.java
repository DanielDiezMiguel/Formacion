package com.bosonit.infrastructure.controller.dto;

import com.bosonit.domain.BackEmpresaReservaEntity;
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

    public BackEmpresaReservaOutputDTO(BackEmpresaReservaEntity backEmpresaReservaEntity) {
        if (backEmpresaReservaEntity == null) return;
        id_persona = backEmpresaReservaEntity.getId_persona();
        ciudad_destino = backEmpresaReservaEntity.getCiudad_destino();
        nombre = backEmpresaReservaEntity.getNombre();
        apellidos = backEmpresaReservaEntity.getApellidos();
        telefono = backEmpresaReservaEntity.getTelefono();
        fecha = backEmpresaReservaEntity.getFecha();
    }
}
