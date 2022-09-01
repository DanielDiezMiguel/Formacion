package com.bosonit.infrastructure.reserva_disponible.repository.mongoDB;

import com.bosonit.domain.reserva_disponible.BackEmpresaReservaDisponibleCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRespositoryDisponible extends MongoRepository<BackEmpresaReservaDisponibleCollection, String> {
}
