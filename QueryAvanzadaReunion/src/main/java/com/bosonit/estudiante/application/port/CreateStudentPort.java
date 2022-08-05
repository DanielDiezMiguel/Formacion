package com.bosonit.estudiante.application.port;

import com.bosonit.estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.estudiante.infrastructure.controller.dto.output.StudentOutputDTO;

public interface CreateStudentPort {
    StudentOutputDTO crearStudent(StudentInputDTO studentInputDTO) throws Exception;
}
