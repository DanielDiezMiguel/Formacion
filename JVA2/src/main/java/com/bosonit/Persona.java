package com.bosonit;

import java.util.Optional;

public record Persona(String nombre, String poblacion, String edad) {

    public Optional<String> getNombre() {
        return Optional.ofNullable(nombre);
    }

    public Optional<String> getPoblacion() {
        return Optional.ofNullable(poblacion);
    }

    public Optional<String> getEdad() {
        return Optional.ofNullable(edad);
    }
}







