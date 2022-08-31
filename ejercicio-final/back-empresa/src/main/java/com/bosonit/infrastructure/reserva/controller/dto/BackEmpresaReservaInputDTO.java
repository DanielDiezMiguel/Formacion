package com.bosonit.infrastructure.reserva.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BackEmpresaReservaInputDTO {
    String id_persona;
    String ciudad;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;
}
