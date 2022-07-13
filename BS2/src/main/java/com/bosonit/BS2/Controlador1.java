package com.bosonit.BS2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
@RestController
public class Controlador1 {
    @Autowired
    @Qualifier("getDataPersona")
    PersonaService personaService;

    @Autowired
    @Qualifier("bean1Qualifier")
    PersonaService personaServiceBean1;

    @Autowired
    @Qualifier("bean2Qualifier")
    PersonaService personaServiceBean2;

    @Autowired
    @Qualifier("bean3Qualifier")
    PersonaService personaServiceBean3;

    @Autowired
    @Qualifier("bean4Qualifier")
    PersonaService personaServiceBean4;

    @Autowired
    CiudadService ciudadService;

    @GetMapping("/controlador1/addPersona")
    public PersonaService getPersonaServiceInfo(@RequestHeader("nombre") String nombre, @RequestHeader("poblacion") String poblacion, @RequestHeader("edad") Integer edad) {
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
    public PersonaService getNombrePS1(@PathVariable String bean) {

        if (bean.equalsIgnoreCase("bean1")) {
            return personaServiceBean1;

        } else if (bean.equalsIgnoreCase("bean2")) {
            return personaServiceBean2;

        } else if (bean.equalsIgnoreCase("bean3")) {
            return personaServiceBean3;

        } else {
            return personaServiceBean4;
        }

    }

}
