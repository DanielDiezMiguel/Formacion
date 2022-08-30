package com.bosonit.infrastructure.reserva_disponible.repository.mongodb;

import com.bosonit.domain.reserva_disponible.BackWebReservaDisponibleCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepositoryDisponible extends MongoRepository<BackWebReservaDisponibleCollection, String> {
}
