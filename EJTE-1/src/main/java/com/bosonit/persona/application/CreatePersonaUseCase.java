package com.bosonit.persona.application;

import com.bosonit.persona.application.port.CreatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreatePersonaUseCase implements CreatePersonaPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO crearUsuario(PersonaInputDTO personaInputDTO) {
        return new PersonaOutputDTO(personaRepository.save(new PersonaEntity(personaInputDTO)));
    }
}