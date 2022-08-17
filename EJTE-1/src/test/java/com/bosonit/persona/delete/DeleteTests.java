package com.bosonit.persona.delete;

import com.bosonit.persona.application.DeletePersonaUseCase;
import com.bosonit.persona.application.port.DeletePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.NoSuchElementException;

@SpringBootTest
class DeleteTests {

	@Autowired
	PersonaRepository personaRepository;

    @Autowired
    DeletePersonaPort deletePersonaPort;

	@Test
    @Rollback(value = false)
	void deletePersona() throws Exception {
		PersonaEntity personaEntity = new PersonaEntity();
		personaEntity.setId_persona(1);
        personaRepository.save(personaEntity);
        deletePersonaPort.deleteByID(personaEntity.getId_persona());
        personaEntity = personaRepository.findById(1).orElseThrow();
		Assertions.assertNull(personaEntity);
	}

}
