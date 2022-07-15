package com.bosonit.BS3;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class Persona {
    protected String nombre = "Daniel";
    protected int edad = 22;

    @Bean
    public String getNombre() {
        return nombre;
    }

    @Bean
    public int getEdad() {
        return edad;
    }
}
