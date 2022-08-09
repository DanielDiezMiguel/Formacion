package com.bosonit.profesor.application.port;

import com.bosonit.profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.bosonit.profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;

public interface CreateProfesorPort {
    ProfesorOutputDTO crearProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;

}
