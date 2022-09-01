package com.bosonit.infrastructure.reserva.repository.mongodb;

import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepositoryEmpresa extends CrudRepository<BackEmpresaReservaCollection, String> {
}
