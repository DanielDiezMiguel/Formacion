package com.bosonit.infrastructure.mail.repository.mongodb;

import com.bosonit.domain.mail.BackEmpresaMailCollection;
import com.bosonit.domain.reserva.BackEmpresaReservaCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDBRespositoryMail extends MongoRepository<BackEmpresaMailCollection, String> {
}
