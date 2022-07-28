package com.bosonit.EstudianteAsignatura.application;

import com.bosonit.EstudianteAsignatura.application.port.ReadEstudianteAsignaturaPort;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.controller.dto.output.EstudianteSoloAsignaturaOutputDTO;
import com.bosonit.EstudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadEstudianteAsignaturaUseCase implements ReadEstudianteAsignaturaPort {
    @Autowired
    EstudianteAsignaturaRespository estudianteAsignaturaRespository;

    @Override
    public EstudianteAsignaturaOutputDTO getAsignaturaByEstudianteID(String id) throws Exception {
        EstudianteAsignaturaEntity estudianteAsignaturaEntity = estudianteAsignaturaRespository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el ID: " + id));
        return new EstudianteSoloAsignaturaOutputDTO(estudianteAsignaturaEntity);
    }
}
