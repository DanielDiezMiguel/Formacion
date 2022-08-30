package com.bosonit.infrastructure.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BackWebReservaInputDTO {
    String ciudad;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;
}
