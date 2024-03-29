package com.bosonit.Profesor.application;

import com.bosonit.Profesor.application.port.ReadProfesorPort;
import com.bosonit.Profesor.domain.ProfesorEntity;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.bosonit.Profesor.infrastructure.repository.jpa.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadProfesorUseCase implements ReadProfesorPort {

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public ProfesorOutputDTO getProfesorByID(String id) throws Exception {
        ProfesorEntity profesorEntity = profesorRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el Profesor con ID: " + id));
        return new ProfesorOutputDTO(profesorEntity);
    }

    @Override
    public List<ProfesorOutputDTO> getAllProfesores() {
        List<ProfesorOutputDTO> profesorOutputDTOList = new ArrayList<>();
        if (profesorRepository.findAll() != null) {
            profesorRepository.findAll().forEach(profesorEntity -> {
                ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesorEntity);
                profesorOutputDTOList.add(profesorOutputDTO);
            });
            return profesorOutputDTOList;

        } else {
            List<ProfesorOutputDTO> profesorOutputDTOListVacia = new ArrayList<>();
            return profesorOutputDTOListVacia;
        }
    }

    @Override
    public List<ProfesorOutputDTO> getProfesorByBranch(String branch) {
        List<ProfesorOutputDTO> profesorOutputDTOList = new ArrayList<>();
        if (profesorRepository.findByBranch(branch) != null) {
            profesorRepository.findByBranch(branch).forEach(profesorEntity -> {
                ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesorEntity);
                profesorOutputDTOList.add(profesorOutputDTO);
            });
            return profesorOutputDTOList;

        } else {
            List<ProfesorOutputDTO> profesorOutputDTOListVacia = new ArrayList<>();
            return profesorOutputDTOListVacia;
        }
    }
}
