package com.bosonit.persona.read;

import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;

@SpringBootTest
class ReadTests {

	@Autowired
	PersonaRepository personaRepository;

	@Test
	void getPersonaByID() {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setId_persona(1);
		personaRepository.save(personaEntity);
		PersonaEntity personaEntityID = personaRepository.findById(1).orElseThrow();
		Assertions.assertEquals(1, personaEntityID.getId_persona());
	}

	@Test
	void getAllPersonas() {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setId_persona(1);
		personaRepository.save(personaEntity);
		ArrayList<PersonaEntity> personaEntityArrayList = new ArrayList<>();
		personaRepository.findAll().forEach(personaEntityID -> personaEntityArrayList.add(personaEntityID));
		Assertions.assertEquals(1, personaEntityArrayList.size());
	}

}
