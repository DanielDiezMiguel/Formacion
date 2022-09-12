package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.DeletePersonaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class DeletePersonaController {

    @Autowired
    DeletePersonaPort deletePersonaPort;

    @DeleteMapping("/id/{id}")
    public void deleteByID(@PathVariable(value = "id") String id) {
        deletePersonaPort.deleteByID(id);
    }
}
