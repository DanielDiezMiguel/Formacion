package com.bosonit.infrastructure.reserva_disponible.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BackWebReservaDisponibleInputDTO {
    String ciudad;
    Date fecha;
    Integer numeroPlazas;
}
