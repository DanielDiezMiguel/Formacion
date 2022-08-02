package com.bosonit.Estudiante.application.port;

import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;

public interface CreateStudentPort {
    StudentOutputDTO crearStudent(StudentInputDTO studentInputDTO) throws Exception;
}
