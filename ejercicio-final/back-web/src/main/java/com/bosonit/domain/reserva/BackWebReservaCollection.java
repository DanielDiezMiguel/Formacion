package com.bosonit.domain.reserva;

import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@NoArgsConstructor
@Document(collection = "reservas")
public class BackWebReservaCollection {

    @Id
    String id_persona;
    String ciudad;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;
    long fechaMs;

    public BackWebReservaCollection(BackWebReservaInputDTO backWebReservaInputDTO) {
        if (backWebReservaInputDTO == null) return;
        ciudad = backWebReservaInputDTO.getCiudad();
        nombre = backWebReservaInputDTO.getNombre();
        apellidos = backWebReservaInputDTO.getApellidos();
        telefono = backWebReservaInputDTO.getTelefono();
        fecha = backWebReservaInputDTO.getFecha();
        fechaMs = backWebReservaInputDTO.getFecha().getTime();
    }
}
