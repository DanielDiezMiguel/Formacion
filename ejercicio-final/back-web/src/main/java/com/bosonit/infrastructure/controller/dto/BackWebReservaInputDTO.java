package com.bosonit.infrastructure.controller.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class BackWebReservaInputDTO {
    String id_persona;
    String ciudad_destino;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;
}
