package com.bosonit.persona.application.port;

import org.springframework.http.ResponseEntity;

public interface DeletePersonaPort {
    ResponseEntity deleteByID(Integer id);
}
