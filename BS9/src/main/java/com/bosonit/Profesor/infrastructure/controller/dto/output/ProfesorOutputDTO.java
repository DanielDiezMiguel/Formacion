package com.bosonit.Profesor.infrastructure.controller.dto.output;

import com.bosonit.Profesor.domain.ProfesorEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProfesorOutputDTO implements Serializable {
    private String id_profesor;
    private String id_persona;
    private String comentarios;
    private String branch;

    public ProfesorOutputDTO(ProfesorEntity profesorEntity) {
        if (profesorEntity == null) return;
        id_profesor = profesorEntity.getId_profesor();
        id_persona = profesorEntity.getPersonaEntity().getId_persona();
        comentarios = profesorEntity.getComentarios();
        branch = profesorEntity.getBranch();
    }
}
