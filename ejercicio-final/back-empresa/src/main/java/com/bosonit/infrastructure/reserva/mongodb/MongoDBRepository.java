package com.bosonit.infrastructure.reserva.mongodb;

import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepository extends CrudRepository<BackEmpresaReservaCollection, String> {
}
