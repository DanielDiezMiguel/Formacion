package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController()
public class Controlador1 {
    @GetMapping("/user/{nombre}")
    public String getHola(@PathVariable String nombre) {
        return "Hola: " + nombre;
    }

    @PostMapping(value = "/useradd")
    public String getInfoPerson(@RequestBody Persona p) {
        p.setEdad(p.getEdad() + 1);
        return "name:" + p.getName() + " edad:" + p.getEdad() + " ciudad:" + p.getCiudad();
    }

}
