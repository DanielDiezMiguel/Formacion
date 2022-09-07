package com.bosonit.infrastructure.reserva.repository.mongodb;

import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepositoryEmpresa extends MongoRepository<BackEmpresaReservaCollection, String> {
}
