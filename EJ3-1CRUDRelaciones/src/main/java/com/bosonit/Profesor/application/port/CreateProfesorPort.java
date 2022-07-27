package com.bosonit.Profesor.application.port;

import com.bosonit.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.bosonit.Profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;

public interface CreateProfesorPort {
    ProfesorOutputDTO crearProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;
}
