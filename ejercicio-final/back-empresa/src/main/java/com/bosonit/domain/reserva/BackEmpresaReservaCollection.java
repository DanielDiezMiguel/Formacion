package com.bosonit.domain.reserva;

import com.bosonit.domain.no_collection.KafkaItem;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaInputDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "reservas")
public class BackEmpresaReservaCollection {
    @Id
    String id_persona;
    String ciudad;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;

    public BackEmpresaReservaCollection(BackEmpresaReservaInputDTO backWebReservaInputDTO) {
        if (backWebReservaInputDTO == null) return;
        ciudad = backWebReservaInputDTO.getCiudad();
        nombre = backWebReservaInputDTO.getNombre();
        apellidos = backWebReservaInputDTO.getApellidos();
        telefono = backWebReservaInputDTO.getTelefono();
        fecha = backWebReservaInputDTO.getFecha();
    }

    public BackEmpresaReservaCollection(KafkaItem kafkaItem) {
        if (kafkaItem == null) return;
        id_persona = kafkaItem.getId_persona();
        ciudad = kafkaItem.getCiudad();
        nombre = kafkaItem.getNombre();
        apellidos = kafkaItem.getApellidos();
        telefono = kafkaItem.getTelefono();
        fecha = kafkaItem.getFecha();
    }
}
