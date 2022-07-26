package com.bosonit.Persona.domain;

import com.bosonit.Estudiante.domain.StudentEntity;
import com.bosonit.Persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Persona")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_seq")
    @GenericGenerator(

            name = "persona_seq",
            strategy = "com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AUS"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")
            })
    private String id_persona;
    @Size(min = 6, max = 10)
    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "company_email", nullable = false)
    private String company_email;

    @Column(name = "personal_email", nullable = false)
    private String personal_email;

    @Column(name = "ciudad", nullable = false)
    private String city;

    @Column(name = "activo", nullable = false)
    private Boolean active;

    @Column(name = "created_date", nullable = false)
    private Date created_date;

    @Column(name = "imagen_URL")
    private String imagen_url;

    @Column(name = "date")
    private Date termination_date;


    public PersonaEntity(PersonaInputDTO usuarioInputDTO) {
        if (usuarioInputDTO == null) return;
        id_persona = usuarioInputDTO.getId_persona();
        usuario = usuarioInputDTO.getUsuario();
        password = usuarioInputDTO.getPassword();
        name = usuarioInputDTO.getName();
        surname = usuarioInputDTO.getSurname();
        company_email = usuarioInputDTO.getCompany_email();
        personal_email = usuarioInputDTO.getPersonal_email();
        city = usuarioInputDTO.getCity();
        active = usuarioInputDTO.getActive();
        created_date = usuarioInputDTO.getCreated_date();
        imagen_url = usuarioInputDTO.getImagen_url();
        termination_date = usuarioInputDTO.getTermination_date();
    }

    public void update(PersonaInputDTO usuarioInputDTO) {
        if (usuarioInputDTO == null) return;
        id_persona = usuarioInputDTO.getId_persona();
        usuario = usuarioInputDTO.getUsuario();
        password = usuarioInputDTO.getPassword();
        name = usuarioInputDTO.getName();
        surname = usuarioInputDTO.getSurname();
        company_email = usuarioInputDTO.getCompany_email();
        personal_email = usuarioInputDTO.getPersonal_email();
        city = usuarioInputDTO.getCity();
        active = usuarioInputDTO.getActive();
        created_date = usuarioInputDTO.getCreated_date();
        imagen_url = usuarioInputDTO.getImagen_url();
        termination_date = usuarioInputDTO.getTermination_date();
    }
}
