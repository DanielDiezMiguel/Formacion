package com.bosonit.infrastructure.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BackEmpresaReservaInputDTO {
    String id_persona;
    String ciudad_destino;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;
}
