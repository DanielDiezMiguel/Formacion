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
        switch (outputType) {
            case "persona":
                PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado la Persona con el ID: " + id));
                return new PersonaOutputDTO(personaEntity);

            case "profesor":
                PersonaEntity personaProfesorEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado la Persona con el ID: " + id));
                return new PersonaOutputDTO(personaProfesorEntity);

            case "student":
                PersonaEntity personaStudentEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado al Student con el ID: " + id));
                return new PersonaStudentOutputDTO(personaStudentEntity);
        }

        return new PersonaOutputDTO(new PersonaEntity());
    }

    @Override
    public List getAllUsuarios(String outputType) {
        switch (outputType) {
            case "persona":
                List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
                personaRepository.findAll().forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
                return personaOutputDTOList;

            case "profesor":
                List<PersonaProfesorOutputDTO> personaProfesorOutputDTOSList = new ArrayList<>();
                personaRepository.findAll().forEach((personaEntity -> personaProfesorOutputDTOSList.add(new PersonaProfesorOutputDTO(personaEntity))));
                return personaProfesorOutputDTOSList;

            case "student":
                List<PersonaStudentOutputDTO> personaStudentOutputDTOList = new ArrayList<>();
                personaRepository.findAll().forEach(personaEntity -> personaStudentOutputDTOList.add(new PersonaStudentOutputDTO(personaEntity)));
                return personaStudentOutputDTOList;
        }

        return new ArrayList<>();
    }

    @Override
    public List getPersonaByName(String name, String outputType) {
        switch (outputType) {
            case "persona":
                List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
                personaRepository.findByName(name).forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
                return personaOutputDTOList;

            case "profesor":
                List<PersonaProfesorOutputDTO> personaProfesorOutputDTOList = new ArrayList<>();
                personaRepository.findByName("profesor").forEach(personaEntity -> personaProfesorOutputDTOList.add(new PersonaProfesorOutputDTO(personaEntity)));
                return personaProfesorOutputDTOList;

            case "student":
                List<PersonaStudentOutputDTO> personaStudentOutputDTOList = new ArrayList<>();
                personaRepository.findByName("student").forEach(personaEntity -> personaStudentOutputDTOList.add(new PersonaStudentOutputDTO(personaEntity)));
                return personaStudentOutputDTOList;
        }

        return new ArrayList<>();
    }

}
