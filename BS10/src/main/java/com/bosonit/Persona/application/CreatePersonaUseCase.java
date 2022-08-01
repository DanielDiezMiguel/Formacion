package com.bosonit.Persona.application;

import com.bosonit.Estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.Persona.application.port.CreatePersonaPort;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Persona.exception.UnprocesableException;
import com.bosonit.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.Persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.Persona.infrastructure.repository.jpa.PersonaRepository;
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
