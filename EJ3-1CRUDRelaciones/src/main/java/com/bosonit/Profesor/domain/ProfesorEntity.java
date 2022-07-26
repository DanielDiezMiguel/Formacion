package com.bosonit.Profesor.domain;

import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@Entity
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

    @OneToOne
    @JoinColumn(name = "id_persona")
    private PersonaEntity id_persona;

    private String comentarios;
    private String branch;
}
