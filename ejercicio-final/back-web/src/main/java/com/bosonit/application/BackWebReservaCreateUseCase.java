package com.bosonit.application;

import com.bosonit.application.port.BackWebReservaCreatePort;
import com.bosonit.domain.BackWebReservaEntity;
import com.bosonit.infrastructure.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.repository.mongodb.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BackWebReservaCreateUseCase implements BackWebReservaCreatePort {

    @Autowired
    MongoDBRepository mongoDBRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<BackWebReservaOutputDTO> crearReserva(BackWebReservaInputDTO backWebReservaInputDTO) {
        if (mongoTemplate.count(Query.query(Criteria.where("_id").exists(true)), "reservas") < 40)
            return ResponseEntity.ok().body(new BackWebReservaOutputDTO(mongoDBRepository.save(new BackWebReservaEntity(backWebReservaInputDTO))));
        else return ResponseEntity.badRequest().build();

    }
}