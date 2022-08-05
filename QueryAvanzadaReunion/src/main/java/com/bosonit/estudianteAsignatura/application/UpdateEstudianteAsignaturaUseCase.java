package com.bosonit.estudianteAsignatura.application;

import com.bosonit.estudianteAsignatura.application.port.UpdateEstudianteAsignaturaPort;
import com.bosonit.estudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.input.EstudianteAsignaturaInputDTO;
import com.bosonit.estudianteAsignatura.infrastructure.controller.dto.output.EstudianteAsignaturaOutputDTO;
import com.bosonit.estudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEstudianteAsignaturaUseCase implements UpdateEstudianteAsignaturaPort {

    @Autowired
    EstudianteAsignaturaRespository estudianteAsignaturaRespository;

    @Override
    public EstudianteAsignaturaOutputDTO updateEstudianteAsignatura(String id, EstudianteAsignaturaInputDTO estudianteAsignaturaInputDTO) throws Exception{
        EstudianteAsignaturaEntity estudianteAsignaturaEntity = estudianteAsignaturaRespository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el ID: " + id));
        estudianteAsignaturaEntity.update(estudianteAsignaturaInputDTO);
        return new EstudianteAsignaturaOutputDTO(estudianteAsignaturaRespository.save(estudianteAsignaturaEntity));
    }
}
