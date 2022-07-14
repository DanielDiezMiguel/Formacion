package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador3 {

    protected int i;
    @Autowired
    @Qualifier("beanQualifier1")
    PersonaService personaService;

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.DELETE)
    public PersonaService deletePersonaByID(@PathVariable(value = "id") int id) {
        for (i = 0; i < personaService.getPersonaList().size(); i++) {
            if (personaService.getPersonaList().get(i).getId() == id) {
                personaService.getPersonaList().remove(id - 1);
            }
        }

        return personaService;

    }
}
