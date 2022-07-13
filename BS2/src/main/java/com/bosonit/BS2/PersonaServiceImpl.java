package com.bosonit.BS2;

import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService{

    Persona p = new Persona();
    @Override
    public String getNombre() {
        return p.getNombre();
    }
    @Override
    public String getPoblacion() {
        return p.getPoblacion();
    }
    @Override
    public Integer getEdad() {
        return p.getEdad();
    }

    @Override
    public void setNombre(String nombre) {
        p.setNombre(nombre);
    }

    @Override
    public void setPoblacion(String poblacion) {
        p.setPoblacion(poblacion);
    }

    @Override
    public void setEdad(Integer edad) {
        p.setEdad(edad);
    }
}
