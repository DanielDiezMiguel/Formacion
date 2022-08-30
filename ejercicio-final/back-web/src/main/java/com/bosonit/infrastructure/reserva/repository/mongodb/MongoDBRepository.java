package com.bosonit.infrastructure.reserva.repository.mongodb;

import com.bosonit.domain.reserva.BackWebReservaCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepository extends MongoRepository<BackWebReservaCollection, String> {
}
