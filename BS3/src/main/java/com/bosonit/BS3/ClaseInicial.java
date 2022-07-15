package com.bosonit.BS3;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ClaseInicial {

    @PostConstruct
    public void primeraFuncion() {
        System.out.println("Hola desde la clase inicial");
    }
}

