package com.bosonit.application.reserva_disponible;

import com.bosonit.application.reserva_disponible.port.BackEmpresaCreateReservaDisponiblePort;
import com.bosonit.domain.reserva_disponible.BackEmpresaReservaDisponibleCollection;
import com.bosonit.exception.BadRequest;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleInputDTO;
import com.bosonit.infrastructure.reserva_disponible.controller.dto.BackEmpresaReservaDisponibleOutputDTO;
import com.bosonit.infrastructure.reserva_disponible.repository.mongoDB.MongoDBRespositoryDisponible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BackEmpresaCreateReservaDisponibleUseCase implements BackEmpresaCreateReservaDisponiblePort {

    @Autowired
    MongoDBRespositoryDisponible mongoDBRespositoryDisponible;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ResponseEntity<BackEmpresaReservaDisponibleOutputDTO> crearReservaDisponible(
            BackEmpresaReservaDisponibleInputDTO backEmpresaReservaDisponibleInputDTO) {

        List<BackEmpresaReservaDisponibleOutputDTO> backEmpresaReservaDisponibleOutputDTOList = new ArrayList<>();

        Query query = Query.query(Criteria.where("ciudad")
                .is(backEmpresaReservaDisponibleInputDTO.getCiudad())
                .and("fechaMs").is(backEmpresaReservaDisponibleInputDTO.getFecha().getTime()));

        mongoTemplate.find(query, BackEmpresaReservaDisponibleCollection.class, "reservas-disponibles")
                .forEach(backEmpresaReservaDisponibleCollection -> backEmpresaReservaDisponibleOutputDTOList.add(
                        new BackEmpresaReservaDisponibleOutputDTO(backEmpresaReservaDisponibleCollection)
                ));

        try {
            if (backEmpresaReservaDisponibleOutputDTOList.size() == 0 &&
                    backEmpresaReservaDisponibleInputDTO.getNumeroPlazas() <= 40)

                return ResponseEntity.ok(new BackEmpresaReservaDisponibleOutputDTO(mongoDBRespositoryDisponible.save(
                        new BackEmpresaReservaDisponibleCollection(backEmpresaReservaDisponibleInputDTO))));

            else if (backEmpresaReservaDisponibleOutputDTOList.get(0).getFecha().getTime() !=
                    backEmpresaReservaDisponibleInputDTO.getFecha().getTime() &&
                    backEmpresaReservaDisponibleInputDTO.getNumeroPlazas() <= 40) {

                return ResponseEntity.ok(new BackEmpresaReservaDisponibleOutputDTO(mongoDBRespositoryDisponible.save(
                        new BackEmpresaReservaDisponibleCollection(backEmpresaReservaDisponibleInputDTO))));

            } else throw new BadRequest("Reserva disponible inválida");

        } catch (Exception e) {
            throw new BadRequest("Reserva invalida");
        }

    }
}
