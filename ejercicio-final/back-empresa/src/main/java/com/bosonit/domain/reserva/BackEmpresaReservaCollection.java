package com.bosonit.domain.reserva;

import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaInputDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "reservas")
public class BackEmpresaReservaCollection {
    @Id
    String id_persona;
    String ciudad_destino;
    String nombre;
    String apellidos;
    int telefono;
    Date fecha;

    public BackEmpresaReservaCollection(BackEmpresaReservaInputDTO backWebReservaInputDTO) {
        if (backWebReservaInputDTO == null) return;
        ciudad_destino = backWebReservaInputDTO.getCiudad_destino();
        nombre = backWebReservaInputDTO.getNombre();
        apellidos = backWebReservaInputDTO.getApellidos();
        telefono = backWebReservaInputDTO.getTelefono();
        fecha = backWebReservaInputDTO.getFecha();
    }
}
