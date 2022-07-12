package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@AllArgsConstructor
@RestController()
public class Persona {
    String name;
    String edad;
    String ciudad;

    @PostMapping("/useradd")
    public Persona getPersona(@PathVariable String name, String edad, String ciudad) {
        return new Persona(name, edad + 1, ciudad);
    }

    @GetMapping("/user/{nombre}")
    public String getHola(@PathVariable String nombre){

        return "Hola: " + nombre;
    }

}
