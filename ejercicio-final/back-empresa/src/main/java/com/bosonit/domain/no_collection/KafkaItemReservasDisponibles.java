package com.bosonit.domain.no_collection;

import lombok.Data;

import java.util.Date;

@Data
public class KafkaItemReservasDisponibles {
    String ciudad;
    Date fecha;
    Integer numeroPlazas;
}
