package com.bosonit.domain.reserva;

import com.bosonit.domain.no_collection.KafkaItemReservas;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
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

    public BackEmpresaReservaCollection(KafkaItemReservas kafkaItemReservas) {
        if (kafkaItemReservas == null) return;
        id_persona = kafkaItemReservas.getId_persona();
        ciudad = kafkaItemReservas.getCiudad();
        nombre = kafkaItemReservas.getNombre();
        apellidos = kafkaItemReservas.getApellidos();
        telefono = kafkaItemReservas.getTelefono();
        fecha = kafkaItemReservas.getFecha();
    }
}
