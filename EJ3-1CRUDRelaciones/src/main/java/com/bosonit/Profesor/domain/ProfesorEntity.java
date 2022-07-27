package com.bosonit.Profesor.domain;

import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Profesor.infrastructure.controller.dto.input.ProfesorInputDTO;
import com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Profesor")
public class ProfesorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    @GenericGenerator(

            name = "profesor_seq",
            strategy = "com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    private String id_profesor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private PersonaEntity personaEntity;

    private String comentarios;
    private String branch;

    public ProfesorEntity(ProfesorInputDTO profesorInputDTO) {
        id_profesor = profesorInputDTO.getId_profesor();
        comentarios = profesorInputDTO.getComentarios();
        branch = profesorInputDTO.getBranch();
    }

    public void update(ProfesorInputDTO profesorInputDTO) {
        comentarios = profesorInputDTO.getComentarios();
        branch = profesorInputDTO.getBranch();
    }
}
