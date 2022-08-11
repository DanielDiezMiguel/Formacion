package com.bosonit.persona.application;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaProfesorOutputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaStudentOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadPersonaUseCase implements ReadPersonaPort {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO getPersonaByID(String id, String outputType) throws Exception {
        if (outputType.equalsIgnoreCase("persona")) {
            PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado la Persona con el ID: " + id));
            return new PersonaOutputDTO(personaEntity);

        } else if (outputType.equalsIgnoreCase("profesor")) {
            PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado al Profesor con el ID: " + id));
            return new PersonaProfesorOutputDTO(personaEntity);

        } else if (outputType.equalsIgnoreCase("student")) {
            PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado al Student con el ID: " + id));
            return new PersonaStudentOutputDTO(personaEntity);
        }

        return new PersonaOutputDTO(new PersonaEntity());
    }

    @Override
    public List getAllUsuarios(String outputType) {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        List<PersonaProfesorOutputDTO> personaProfesorOutputDTOSList = new ArrayList<>();
        List<PersonaStudentOutputDTO> personaStudentOutputDTOList = new ArrayList<>();

        if (personaRepository.findAll() != null) {
            if (outputType.equalsIgnoreCase("persona")) {
                personaRepository.findAll().forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
                return personaOutputDTOList;

            } else if (outputType.equalsIgnoreCase("profesor")) {
                personaRepository.findAll().forEach((personaEntity -> personaProfesorOutputDTOSList.add(new PersonaProfesorOutputDTO(personaEntity))));
                return personaProfesorOutputDTOSList;

            } else if (outputType.equalsIgnoreCase("student")) {
                personaRepository.findAll().forEach(personaEntity -> personaStudentOutputDTOList.add(new PersonaStudentOutputDTO(personaEntity)));
                return personaStudentOutputDTOList;
            }
        }
        return new ArrayList<>();
    }

    @Override
    public List getPersonaByName(String name, String outputType) {
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        List<PersonaProfesorOutputDTO> personaProfesorOutputDTOS = new ArrayList<>();
        List<PersonaStudentOutputDTO> personaStudentOutputDTOList = new ArrayList<>();

        if (personaRepository.findByName(name) != null) {
            if (outputType.equalsIgnoreCase("persona")) {
                personaRepository.findByName(name).forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
                return personaOutputDTOList;

            } else if (outputType.equalsIgnoreCase("profesor")) {
                personaRepository.findByName("profesor").forEach(personaEntity -> personaOutputDTOList.add(new PersonaProfesorOutputDTO(personaEntity)));
                return personaProfesorOutputDTOS;

            } else if (outputType.equalsIgnoreCase("student")) {
                personaRepository.findByName("student").forEach(personaEntity -> personaStudentOutputDTOList.add(new PersonaStudentOutputDTO(personaEntity)));
                return personaStudentOutputDTOList;
            }
        }

        return new ArrayList<>();
    }

}
