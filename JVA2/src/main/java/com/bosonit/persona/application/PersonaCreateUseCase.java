package com.bosonit.persona.application;

import com.bosonit.persona.application.port.PersonaCreatePort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.bosonit.persona.infrastructure.controller.dto.PersonaOutputDTO;
import com.bosonit.persona.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaCreateUseCase implements PersonaCreatePort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO crearPersona(PersonaInputDTO personaInputDTO) throws Exception {
        if (personaInputDTO.getUsuario().length() < 6 || personaInputDTO.getUsuario().length() > 10)
            throw new Exception("El usuario debe tener entre 6 y 10 carácteres");

        PersonaEntity personaEntity = new PersonaEntity(personaInputDTO);
        personaRepository.save(personaEntity);
        return new PersonaOutputDTO(personaEntity);

    }
}
