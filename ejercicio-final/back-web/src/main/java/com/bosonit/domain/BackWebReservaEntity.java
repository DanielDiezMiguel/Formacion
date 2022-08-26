package com.bosonit.domain;

import com.bosonit.infrastructure.controller.dto.BackWebReservaInputDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document(collection = "reservas")
public class BackWebReservaEntity {

    @Id
    String id_persona;
    String ciudad_destino;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;

    public BackWebReservaEntity(BackWebReservaInputDTO backWebReservaInputDTO) {
        if (backWebReservaInputDTO == null) return;
        ciudad_destino = backWebReservaInputDTO.getCiudad_destino();
        nombre = backWebReservaInputDTO.getNombre();
        apellidos = backWebReservaInputDTO.getApellidos();
        telefono = backWebReservaInputDTO.getTelefono();
        fecha = backWebReservaInputDTO.getFecha();
    }
}
