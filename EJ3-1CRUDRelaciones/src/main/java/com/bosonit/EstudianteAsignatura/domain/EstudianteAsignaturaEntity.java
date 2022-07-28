package com.bosonit.EstudianteAsignatura.domain;

import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Profesor.domain.ProfesorEntity;
import com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Estudiante_Asignatura")
public class EstudianteAsignaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudianteAsignatura_seq")
    @GenericGenerator(

            name = "estudianteAsignatura_seq",
            strategy = "com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    private String id_asignatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private ProfesorEntity profesorEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private StudentEntity studentEntity;

    private String asignatura;
    private String comment;

    @Column(name = "initial_date", nullable = false)
    private Date initial_date;

    private Date finish_date;

}
