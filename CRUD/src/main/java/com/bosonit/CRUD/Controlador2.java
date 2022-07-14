package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controlador2 {

    @Autowired
    @Qualifier("beanQualifier1")
    PersonaService personaService;

    protected AtomicInteger atomicInteger = new AtomicInteger();
    protected int i = 0;

    @PutMapping("/persona/{id}")
    public PersonaService updatePersona(@RequestBody Persona p, @PathVariable(value = "id") int id) {
        for (i = 0; i < personaService.getPersonaList().size(); i++) {
            if (personaService.getPersonaList().get(i).getId() == id) {
                personaService.getPersonaList().get(id - 1).setNombre("Rafael");
            }
        }

        return personaService;
    }
}
