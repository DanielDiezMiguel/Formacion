package com.bosonit.domain.reserva_disponible;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "reserva-disponible")
public class BackEmpresaReservaDisponibleCollection {
    @Id
    String id_reserva_disponible;
    String ciudad;
    Date fecha;
    Integer numeroPlazas;
}
