package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controlador1 {

    protected AtomicInteger atomicInteger = new AtomicInteger();
    @Autowired
    @Qualifier("beanQualifier1")
    PersonaService personaService;

    @RequestMapping(value = "/persona", method = RequestMethod.POST)
    public PersonaService addPersona(@RequestBody Persona p) {
        p.setId(atomicInteger.incrementAndGet());
        personaService.addPersona(p);
        return personaService;
    }
}
