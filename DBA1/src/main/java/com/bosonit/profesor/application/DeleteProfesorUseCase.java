package com.bosonit.profesor.application;

import com.bosonit.profesor.application.port.DeleteProfesorPort;
import com.bosonit.profesor.domain.ProfesorEntity;
import com.bosonit.profesor.infrastructure.repository.jpa.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfesorUseCase implements DeleteProfesorPort {

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public void deleteProfesorByID(String id) throws Exception{
        ProfesorEntity profesorEntity = profesorRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado el Profesor con el ID: " + id));
        profesorRepository.deleteById(id);
    }
}
