package com.bosonit.estudianteAsignatura.application;

import com.bosonit.estudianteAsignatura.application.port.DeleteEstudianteAsignaturaPort;
import com.bosonit.estudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.estudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEstudianteAsignaturaUseCase implements DeleteEstudianteAsignaturaPort {

    @Autowired
    EstudianteAsignaturaRespository estudianteAsignaturaRespository;

    @Override
    public void deleteByID(String id) throws Exception {
        EstudianteAsignaturaEntity estudianteAsignaturaEntity = estudianteAsignaturaRespository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el ID: " + id));
        estudianteAsignaturaRespository.deleteById(id);
    }
}
