package com.bosonit.persona.infrastructure.controller;

import com.bosonit.persona.application.port.PersonaDeletePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class PersonaDeleteController {

    @Autowired
    PersonaDeletePort personaDeletePort;

    @DeleteMapping("{id}")
    public void deleteByID(@PathVariable(name = "id") Integer id) throws Exception {
        personaDeletePort.deleteByID(id);
    }
}
