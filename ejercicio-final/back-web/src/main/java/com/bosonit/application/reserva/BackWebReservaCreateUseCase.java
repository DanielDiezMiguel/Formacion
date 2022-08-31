package com.bosonit.application.reserva;

import com.bosonit.application.reserva.port.BackWebReservaCreatePort;
import com.bosonit.domain.reserva.BackWebReservaCollection;
import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.exception.UnprocesableException;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaInputDTO;
import com.bosonit.infrastructure.reserva.controller.dto.BackWebReservaOutputDTO;
import com.bosonit.infrastructure.reserva.repository.mongodb.MongoDBRepository;
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
        try {
            if (mongoTemplate.exists(Query.query(Criteria.where("ciudad").is(backWebReservaInputDTO.getCiudad())),
                    BackWebReservaDisponibleCollection.class, "reservas-disponibles") &&
                    mongoTemplate.exists(Query.query(Criteria.where("numeroPlazas").lte(40)),
                    BackWebReservaDisponibleCollection.class, "reservas-disponibles"))

                return ResponseEntity.ok(
                        new BackWebReservaOutputDTO(mongoDBRepository.save(
                                new BackWebReservaCollection(backWebReservaInputDTO))));

        } catch (Exception e) {
            throw new BadRequest("Reserva inválida");
        }
        throw new UnprocesableException("No quedan plazas disponibles");
    }
}