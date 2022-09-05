package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackWebReservaDisponiblePort;
import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackWebReservaDisponibleOutputDTO;
import com.bosonit.infrastructure.reserva_disponible.repository.mongodb.MongoDBRepositoryDisponible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackWebReservaDisponibleCreateUseCase implements BackWebReservaDisponiblePort {

    @Autowired
    MongoDBRepositoryDisponible mongoDBRepositoryDisponible;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<BackWebReservaDisponibleOutputDTO>
    crearReservaDisponible(BackWebReservaDisponibleInputDTO backWebReservaDisponibleInputDTO) {

        List<BackWebReservaDisponibleOutputDTO> backWebReservaDisponibleOutputDTOList = new ArrayList<>();

        Query query = Query.query(Criteria.where("ciudad")
                .is(backWebReservaDisponibleInputDTO.getCiudad())
                .and("fechaMs").is(backWebReservaDisponibleInputDTO.getFecha().getTime()));

        mongoTemplate.find(query, BackWebReservaDisponibleCollection.class, "reservas-disponibles")
                .forEach(backEmpresaReservaDisponibleCollection -> backWebReservaDisponibleOutputDTOList.add(
                        new BackWebReservaDisponibleOutputDTO(backEmpresaReservaDisponibleCollection)
                ));
        try {
            if ((backWebReservaDisponibleOutputDTOList.size() == 0 &&
                    backWebReservaDisponibleInputDTO.getNumeroPlazas() <= 40) ||
                    (backWebReservaDisponibleOutputDTOList.get(0).getFecha().getTime() !=
                            backWebReservaDisponibleInputDTO.getFecha().getTime() &&
                            backWebReservaDisponibleInputDTO.getNumeroPlazas() <= 40))

                return ResponseEntity.ok(new BackWebReservaDisponibleOutputDTO(mongoDBRepositoryDisponible.save(
                        new BackWebReservaDisponibleCollection(backWebReservaDisponibleInputDTO))));

            else throw new BadRequest("Reserva disponible inválida");

        } catch (Exception e) {
            throw new BadRequest("Reserva disponible invalida");
        }
    }
}
