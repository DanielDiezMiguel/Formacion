package com.bosonit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestApplication {

    @Autowired
    PersonaJPA personaJPA;

    @Test
    @Order(1)
    @Rollback(value = false)
    void savePersona() {
        PersonaEntity personaEntity = new PersonaEntity("Daniel");
        personaJPA.save(personaEntity);
        Assertions.assertEquals("Daniel", personaEntity.getName());
    }

    @Test
    @Order(2)
    void readPersonaByID() {
        PersonaEntity personaEntity = personaJPA.findById(1).orElseThrow();
        Assertions.assertEquals(1, personaEntity.getId());
    }

    @Test
    @Order(3)
    void readPersonaAll() {
        List<PersonaEntity> personaEntitiesList = personaJPA.findAll();
        Assertions.assertEquals(1, personaEntitiesList.size());
    }

    @Test
    @Order(4)
    void updatePersona() {
        PersonaEntity personaModificada = personaJPA.save(new PersonaEntity(1, "DanielUpdate"));
        Assertions.assertEquals("DanielUpdate", personaModificada.getName());
    }

    @Test
    @Order(5)
    void deletePersona() {
        personaJPA.delete(personaJPA.findById(1).orElseThrow());
        Optional<PersonaEntity> personaEntityOptional = personaJPA.findById(1);
        Assertions.assertEquals(Optional.empty(), personaEntityOptional);
    }

    @Test
    @Order(6)
    void setGetPersona() {
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(1);
        personaEntity.setName("Daniel");
        String name = personaEntity.getName();
        int id = personaEntity.getId();
        Assertions.assertEquals(1, id);
        Assertions.assertEquals("Daniel", name);
    }

    @Test
    @Order(7)
    public void main() {
        Ejtesimple1Application.main(new String[] {});
    }
}