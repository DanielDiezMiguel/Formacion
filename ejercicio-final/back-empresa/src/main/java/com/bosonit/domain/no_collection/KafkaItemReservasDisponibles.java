package com.bosonit.domain.no_collection;

import lombok.Data;

import java.util.Date;

@Data
public class KafkaItemReservasDisponibles {
    String id_reserva_disponible;
    String ciudad;
    Date fecha;
//    long fechaMs = fecha.getTime();
    Integer numeroPlazas;
}
