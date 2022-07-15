package com.bosonit.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClaseTerciaria {

    @Bean
    CommandLineRunner ejecutame(Persona p) {
        return args -> {
            System.out.println("Hola en la tercera clase, soy: " + p.getNombre() + " y tengo: " + p.getEdad() + " años.");
        };

    }
}
