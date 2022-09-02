package com.bosonit.domain.reserva_disponible;

import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "reservas-disponibles")
public class BackEmpresaReservaDisponibleCollection {
    @Id
    String id_reserva_disponible;
    String ciudad;
    Date fecha;
    Integer numeroPlazas;

    public BackEmpresaReservaDisponibleCollection(BackEmpresaReservaDisponibleInputDTO backEmpresaReservaDisponibleInputDTO) {
        if (backEmpresaReservaDisponibleInputDTO == null) return;
        id_reserva_disponible = backEmpresaReservaDisponibleInputDTO.getId_reserva_disponible();
        ciudad = backEmpresaReservaDisponibleInputDTO.getCiudad();
        fecha = backEmpresaReservaDisponibleInputDTO.getFecha();
        numeroPlazas = backEmpresaReservaDisponibleInputDTO.getNumeroPlazas();
    }
}
