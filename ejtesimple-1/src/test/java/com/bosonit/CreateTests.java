package com.bosonit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreateTests {

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

}