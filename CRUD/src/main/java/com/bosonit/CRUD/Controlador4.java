package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador4 {

    @Autowired
    @Qualifier("beanQualifier1")
    PersonaService personaService;

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
    public Persona getPersonaServiceInfoByID(@PathVariable(value = "id") int id) {
        return personaService.getPersonaListByID(id - 1);
    }
    @RequestMapping(value = "/persona/nombre/{nombre}", method = RequestMethod.GET)
    public Persona getPersonaServiceInfoByName(@PathVariable(value = "nombre") String nombre) {
       return personaService.getPersonaListByName(nombre);

    }
}
