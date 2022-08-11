package com.bosonit.persona.application;

import com.bosonit.persona.application.port.CreatePersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.exception.UnprocesableException;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import com.bosonit.Profesor.infrastructure.repository.jpa.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CreatePersonaUseCase implements CreatePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO crearUsuario(@Valid PersonaInputDTO personaInputDTO) {
        try {
            PersonaEntity personaEntity = new PersonaEntity(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
            return personaOutputDTO;

        } catch (Exception e) {
            throw new UnprocesableException("No cumple los requisitos establecidos");
        }

    }
}
