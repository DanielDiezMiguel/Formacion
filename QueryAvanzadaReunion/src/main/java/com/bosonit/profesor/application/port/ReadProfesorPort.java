package com.bosonit.profesor.application.port;

import com.bosonit.profesor.infrastructure.controller.dto.output.ProfesorOutputDTO;

import java.util.List;

public interface ReadProfesorPort {
    ProfesorOutputDTO getProfesorByID(String id) throws Exception;

    List<ProfesorOutputDTO> getAllProfesores();

    List<ProfesorOutputDTO> getProfesorByBranch(String branch);
}
