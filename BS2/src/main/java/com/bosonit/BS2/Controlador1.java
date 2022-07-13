package com.bosonit.BS2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
@RestController
public class Controlador1 {
    @Autowired
    @Qualifier("getDataPersona")
    PersonaService personaService;
    @Autowired
    CiudadService ciudadService;

    @GetMapping("/controlador1/addPersona")
    public PersonaService getPersonaServiceInfo(
            @RequestHeader("nombre") String nombre,
            @RequestHeader("poblacion") String poblacion,
            @RequestHeader("edad") Integer edad
    ) {
        personaService.setNombre(nombre);
        personaService.setPoblacion(poblacion);
        personaService.setEdad(edad);

        return personaService;
    }

    @PostMapping("/controlador1/addCiudad")
    public CiudadService addCiudad(@RequestBody Ciudad c) {
        ciudadService.addCiudad(c);
        return ciudadService;
    }

    @GetMapping("/controlador/bean/{bean}")
    public PersonaService getNombrePS1() {
        personaService.setNombre(personaService.getNombre());
        return personaService;
    }

}
