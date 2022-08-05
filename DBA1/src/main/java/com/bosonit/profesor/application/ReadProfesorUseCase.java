package com.bosonit.profesor.application;

import com.bosonit.profesor.application.port.ReadProfesorPort;
import com.bosonit.profesor.domain.ProfesorEntity;
import com.bosonit.profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;
import com.bosonit.profesor.infrastructure.repository.jpa.ProfesorRepository;
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
        profesorRepository.findAll().forEach(profesorEntity -> profesorOutputDTOList.add(new ProfesorOutputDTO(profesorEntity)));
        return profesorOutputDTOList;

    }

    @Override
    public List<ProfesorOutputDTO> getProfesorByBranch(String branch) {
        List<ProfesorOutputDTO> profesorOutputDTOList = new ArrayList<>();
        profesorRepository.findByBranch(branch).forEach(profesorEntity -> profesorOutputDTOList.add(new ProfesorOutputDTO(profesorEntity)));
        return profesorOutputDTOList;

    }
}
