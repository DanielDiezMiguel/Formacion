package com.bosonit.persona.application.port;

import org.springframework.http.ResponseEntity;

public interface DeletePersonaPort {
//    void deleteByID(String id);

    ResponseEntity deleteByID(Integer id);
}
