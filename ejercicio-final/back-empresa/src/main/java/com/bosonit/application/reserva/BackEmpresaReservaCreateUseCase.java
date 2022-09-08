package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.BackEmpresaReservaCreatePort;
import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaOutputDTO;
import com.bosonit.infrastructure.reserva.repository.mongodb.MongoDBRepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BackEmpresaReservaCreateUseCase implements BackEmpresaReservaCreatePort {

    @Autowired
    MongoDBRepositoryEmpresa mongoDBRepositoryEmpresa;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<BackEmpresaReservaOutputDTO> crearReserva(BackEmpresaReservaInputDTO backEmpresaReservaInputDTO) {
        return ResponseEntity.ok(new BackEmpresaReservaOutputDTO(mongoDBRepositoryEmpresa
                .save(new BackEmpresaReservaCollection(backEmpresaReservaInputDTO))));
    }
}