package com.bosonit.CRUD;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService{
    List<Persona> personaList = new ArrayList<>();

    @Override
    public void addPersona(Persona p) {
        personaList.add(p);
    }

    @Override
    public List<Persona> getPersonaList() {
        return personaList;
    }

}
