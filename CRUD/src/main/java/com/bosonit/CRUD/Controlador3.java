package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador3 {

    @Autowired
    @Qualifier("beanQualifier2")
    PersonaService personaService;

    

}
