package com.bosonit.EstudianteAsignatura.application;

import com.bosonit.EstudianteAsignatura.application.port.DeleteEstudianteAsignaturaPort;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.EstudianteAsignatura.infrastructure.repository.jpa.EstudianteAsignaturaRespository;
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
 //       estudianteAsignaturaRespository.save(estudianteAsignaturaEntity);
    }
}
