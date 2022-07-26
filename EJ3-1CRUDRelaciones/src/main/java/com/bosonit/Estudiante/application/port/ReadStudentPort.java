package com.bosonit.Estudiante.application.port;

import com.bosonit.Estudiante.infrastructure.controller.dto.output.StudentOutputDTO;

import java.util.List;

public interface ReadStudentPort {
    StudentOutputDTO getStudentByID(String id) throws Exception;
    List<StudentOutputDTO> getAllStudents();
    List<StudentOutputDTO> getStudentByBranch(String branch);
}
