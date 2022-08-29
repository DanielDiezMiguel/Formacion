package com.bosonit.application;

import com.bosonit.application.port.BackEmpresaReservaPort;
import com.bosonit.domain.BackEmpresaReservaEntity;
import com.bosonit.exception.UnprocesableException;
import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackEmpresaReservaOutputDTO;
import com.bosonit.infrastructure.repository.mongodb.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class BackEmpresaReservaUseCase implements BackEmpresaReservaPort {

    @Autowired
    MongoDBRepository mongoDBRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public BackEmpresaReservaOutputDTO crearReserva(BackEmpresaReservaInputDTO backEmpresaReservaInputDTO) {
        if (mongoTemplate.count(Query.query(Criteria.where("_id").exists(true)), "reservas") <= 40)
            return new BackEmpresaReservaOutputDTO(mongoDBRepository.save(new BackEmpresaReservaEntity(backEmpresaReservaInputDTO)));
        else throw new UnprocesableException("El número de reservas es superior a 40");

    }
}