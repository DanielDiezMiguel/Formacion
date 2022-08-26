package com.bosonit.application;

import com.bosonit.application.port.BackWebReservaPort;
import com.bosonit.domain.BackWebReservaEntity;
import com.bosonit.infrastructure.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.repository.mongodb.MongoDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackWebCrearReservaUseCase implements BackWebReservaPort {

    @Autowired
    MongoDBRepository mongoDBRepository;

    @Override
    public BackWebReservaOutputDTO crearReserva(BackWebReservaInputDTO backWebReservaInputDTO) {
        return new BackWebReservaOutputDTO(mongoDBRepository.save(new BackWebReservaEntity(backWebReservaInputDTO)));
    }
}