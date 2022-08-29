package com.bosonit.infrastructure.repository.mongodb;

import com.bosonit.domain.BackWebReservaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRepository extends MongoRepository<BackWebReservaEntity, String> {
}
