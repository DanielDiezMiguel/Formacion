package com.bosonit.BS2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;
    @Autowired
    CiudadService ciudadService;

    @GetMapping("/controlador1/addPersona")
    public PersonaService getPersonaServiceInfo(
            @RequestHeader("nombre") String nombre,
            @RequestHeader("poblacion") String poblacion,
            @RequestHeader("edad") Integer edad
    )
    {
        personaService.setNombre(nombre);
        personaService.setPoblacion(poblacion);
        personaService.setEdad(edad);

        return personaService;
    }
    @PostMapping("/controlador1/addCiudad")
    public CiudadService addCiudad(@RequestBody Ciudad c){
        ciudadService.addCiudad(c);
        return ciudadService;
    }

}
