package com.bosonit.infrastructure.controller;

import com.bosonit.application.port.DeletePersonaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    DeletePersonaPort deletePersonaPort;

    // DELETE
    @DeleteMapping("/usuario/delete/{id}")
    public void deleteByID(@PathVariable(value = "id") Integer id) {
        deletePersonaPort.deleteByID(id);
    }
}
