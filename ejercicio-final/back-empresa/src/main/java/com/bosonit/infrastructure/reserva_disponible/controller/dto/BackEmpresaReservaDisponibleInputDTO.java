package com.bosonit.infrastructure.reserva_disponible.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BackEmpresaReservaDisponibleInputDTO {
    String id_reserva_disponible;
    String ciudad;
    Date fecha;
    Integer numeroPlazas;
}
