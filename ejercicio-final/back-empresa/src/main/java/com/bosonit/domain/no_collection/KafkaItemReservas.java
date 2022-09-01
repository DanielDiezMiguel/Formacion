package com.bosonit.domain.no_collection;

import lombok.Data;

import java.util.Date;

@Data
public class KafkaItemReservas {
    String id_persona;
    String ciudad;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;

}
