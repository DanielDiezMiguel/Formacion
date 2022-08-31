package com.bosonit.application.reserva_disponible.port;


import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaOutputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleOutputDTO;
import org.springframework.http.ResponseEntity;

public interface BackEmpresaCreateReservaDisponiblePort {
    ResponseEntity<BackEmpresaReservaDisponibleOutputDTO> crearReservaDisponible(
            BackEmpresaReservaDisponibleInputDTO backEmpresaReservaDisponibleInputDTO, String ciudad);
//    ResponseEntity<BackEmpresaReservaOutputDTO> crearReserva(BackEmpresaReservaInputDTO backEmpresaReservaInputDTO);
}
