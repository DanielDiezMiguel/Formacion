package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controlador1 {

    protected AtomicInteger atomicInteger = new AtomicInteger();
    @Autowired
    @Qualifier("beanQualifier1")
    PersonaService personaService;

    @PostMapping("/persona")
    public PersonaService addPersona(@RequestBody Persona p) {
        p.setId(atomicInteger.incrementAndGet());
        personaService.addPersona(p);
        return personaService;
    }
}
