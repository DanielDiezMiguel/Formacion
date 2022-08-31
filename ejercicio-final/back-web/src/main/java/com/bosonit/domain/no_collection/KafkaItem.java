package com.bosonit.domain.no_collection;

import com.bosonit.domain.reserva.BackWebReservaCollection;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import lombok.Data;

import java.util.Date;

@Data
public class KafkaItem {
    String id_persona;
    String ciudad;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;

}
