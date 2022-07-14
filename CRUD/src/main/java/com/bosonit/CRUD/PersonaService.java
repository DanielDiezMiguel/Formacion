package com.bosonit.CRUD;

import java.util.List;

public interface PersonaService {
    void addPersona(Persona p);

    List<Persona> getPersonaList();

    Persona getPersonaListByID(int id);

    Persona getPersonaListByName(String nombre);

}
