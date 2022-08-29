package com.bosonit.infrastructure.repository.mongodb;

import com.bosonit.domain.BackEmpresaReservaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepository extends CrudRepository<BackEmpresaReservaEntity, String> {
}
