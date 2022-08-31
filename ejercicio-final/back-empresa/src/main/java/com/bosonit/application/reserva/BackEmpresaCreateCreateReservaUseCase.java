package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.BackEmpresaCreateReservaPort;
import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.reserva.controller.dto.BackEmpresaReservaOutputDTO;
import com.bosonit.infrastructure.reserva.mongodb.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BackEmpresaCreateCreateReservaUseCase implements BackEmpresaCreateReservaPort {

    @Autowired
    MongoDBRepository mongoDBRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<BackEmpresaReservaOutputDTO> crearReserva(BackEmpresaReservaInputDTO backEmpresaReservaInputDTO) {
        if (mongoTemplate.count(Query.query(Criteria.where("_id").exists(true)), "reservas") < 40)
            return ResponseEntity.ok().body(new BackEmpresaReservaOutputDTO(mongoDBRepository.save(new BackEmpresaReservaCollection(backEmpresaReservaInputDTO))));
         else return ResponseEntity.badRequest().build();
    }
}