package com.bosonit.persona.create;

import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;

@SpringBootTest
class CreateTests {

	@Autowired
	PersonaRepository personaRepository;

	@Test
	void savePersona() {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setId_persona(1);
		personaRepository.save(personaEntity);
		Assertions.assertEquals(1, personaEntity.getId_persona());
	}

}
