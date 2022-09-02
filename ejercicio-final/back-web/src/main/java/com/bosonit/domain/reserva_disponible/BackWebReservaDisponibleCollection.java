package com.bosonit.domain.reserva_disponible;

import com.bosonit.domain.no_collection.KafkaItemReservasDisponibles;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "reservas-disponibles")
public class BackWebReservaDisponibleCollection {

    @Id
    String id_reserva_disponible;
    String ciudad;
    Date fecha;
    long fechaMs;
    Integer numeroPlazas;

    public BackWebReservaDisponibleCollection(BackWebReservaDisponibleInputDTO backWebReservaDisponibleInputDTO) {
        if (backWebReservaDisponibleInputDTO == null) return;
        ciudad = backWebReservaDisponibleInputDTO.getCiudad();
        fecha = backWebReservaDisponibleInputDTO.getFecha();
        fechaMs = backWebReservaDisponibleInputDTO.getFecha().getTime();
        numeroPlazas = backWebReservaDisponibleInputDTO.getNumeroPlazas();
    }

    public BackWebReservaDisponibleCollection(KafkaItemReservasDisponibles kafkaItemReservasDisponibles) {
        ciudad = kafkaItemReservasDisponibles.getCiudad();
        fecha = kafkaItemReservasDisponibles.getFecha();
        numeroPlazas = kafkaItemReservasDisponibles.getNumeroPlazas();
    }

    public void update(KafkaItemReservasDisponibles kafkaItemReservasDisponibles) {
        if (kafkaItemReservasDisponibles == null) return;
        ciudad = kafkaItemReservasDisponibles.getCiudad();
        fecha = kafkaItemReservasDisponibles.getFecha();
        numeroPlazas = kafkaItemReservasDisponibles.getNumeroPlazas();
    }
}
