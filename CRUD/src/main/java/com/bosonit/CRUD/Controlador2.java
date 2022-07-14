package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @Autowired
    @Qualifier("beanQualifier1")
    PersonaService personaService;
    protected int i;

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.PUT)
    public PersonaService updatePersona(@PathVariable(value = "id") int id) {
        for (i = 0; i < personaService.getPersonaList().size(); i++) {
            if (personaService.getPersonaList().get(i).getId() == id) {
                personaService.getPersonaList().get(id - 1).setNombre("Rafael");
                personaService.getPersonaList().get(id - 1).setEdad(27);
                personaService.getPersonaList().get(id - 1).setPoblación("Madrid");
            }

        }

        return personaService;
    }
}
