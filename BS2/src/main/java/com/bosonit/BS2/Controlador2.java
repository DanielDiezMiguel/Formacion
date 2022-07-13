package com.bosonit.BS2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {
    @Autowired
    PersonaService personaService;

    @Autowired
    CiudadService ciudadService;

    @GetMapping("/controlador2/getPersona")
    public PersonaService getPersonaServiceEdad() {
        personaService.setEdad(personaService.getEdad() * 2);
        return personaService;
    }

    @GetMapping("/controlador2/getCiudad")
    public CiudadService getCiudad(){
        ciudadService.getCiudades();
        return ciudadService;
    }

}
