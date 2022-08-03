package com.bosonit.Profesor.application;

import com.bosonit.estudiante.infrastructure.repository.jpa.StudentRepository;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import com.bosonit.Profesor.application.port.CreateProfesorPort;
import com.bosonit.Profesor.domain.ProfesorEntity;
import com.bosonit.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.bosonit.Profesor.infrastructure.repository.jpa.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProfesorUseCase implements CreateProfesorPort {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ProfesorOutputDTO crearProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        PersonaEntity personaEntity = personaRepository.findById(profesorInputDTO.getId_persona()).orElseThrow(() -> new Exception("No se ha encontrado el ID"));
        ProfesorEntity profesorEntity = new ProfesorEntity(profesorInputDTO);
        profesorEntity.setPersonaEntity(personaEntity);
        profesorRepository.save(profesorEntity);
        return new ProfesorOutputDTO(profesorEntity);
    }
}
