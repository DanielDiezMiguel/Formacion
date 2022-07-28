package com.bosonit.Estudiante.domain;

import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
import com.bosonit.Persona.domain.PersonaEntity;
import com.bosonit.Profesor.domain.ProfesorEntity;
import com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @GenericGenerator(

            name = "student_seq", strategy = "com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator", parameters = {@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"), @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"), @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")})
    private String id_student;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona")
    private PersonaEntity personaEntity;

    private int num_hours_week;
    private String comentarios;

    @ManyToOne
    @JoinColumn(name = "profesorEntity")
    private ProfesorEntity profesorEntity;

    @OneToMany(mappedBy = "studentEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<EstudianteAsignaturaEntity> estudianteAsignaturaEntities = new HashSet<>();

    @Column(name = "rama")
    private String branch;

    @OneToMany
    private List<EstudianteAsignaturaEntity> estudios;

    public StudentEntity(StudentInputDTO studentInputDTO) {
        if (studentInputDTO == null) return;
        id_student = studentInputDTO.getId_student();
        num_hours_week = studentInputDTO.getNum_hours_week();
        comentarios = studentInputDTO.getComentarios();
        branch = studentInputDTO.getBranch();
        //estudios = studentInputDTO.getEstudios();
    }

    public void update(StudentInputDTO studentInputDTO) {
        if (studentInputDTO == null) return;
        num_hours_week = studentInputDTO.getNum_hours_week();
        comentarios = studentInputDTO.getComentarios();
        branch = studentInputDTO.getBranch();
        //estudios = studentInputDTO.getEstudios();
    }

}
