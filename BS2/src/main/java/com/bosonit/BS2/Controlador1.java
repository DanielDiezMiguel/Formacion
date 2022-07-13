package com.bosonit.BS2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {
    @GetMapping("/controlador1/addPersona")
    public Persona getPersonaInfo(
            @RequestHeader("nombre") String nombre,
            @RequestHeader("poblacion") String poblacion,
            @RequestHeader("edad") Integer edad
    )
    {
        return new Persona(nombre, poblacion, edad);
    }

}
