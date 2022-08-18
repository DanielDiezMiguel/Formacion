package com.bosonit.persona.domain;

import com.bosonit.estudiante.domain.StudentEntity;
import com.bosonit.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.profesor.domain.ProfesorEntity;
import com.bosonit.shared.sequences.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
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

    @OneToOne(mappedBy = "personaEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private StudentEntity studentEntity;

    @OneToOne(mappedBy = "personaEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProfesorEntity profesorEntity;

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

    @Column(name = "admin", nullable = false)
    private boolean admin;


    public PersonaEntity(PersonaInputDTO personaInputDTO) {
        if (personaInputDTO == null) return;
        id_persona = personaInputDTO.getId_persona();
        usuario = personaInputDTO.getUsuario();
        password = personaInputDTO.getPassword();
        name = personaInputDTO.getName();
        surname = personaInputDTO.getSurname();
        company_email = personaInputDTO.getCompany_email();
        personal_email = personaInputDTO.getPersonal_email();
        city = personaInputDTO.getCity();
        active = personaInputDTO.getActive();
        created_date = personaInputDTO.getCreated_date();
        imagen_url = personaInputDTO.getImagen_url();
        termination_date = personaInputDTO.getTermination_date();
        admin = personaInputDTO.isAdmin();
    }

    public void update(PersonaInputDTO personaInputDTO) {
        if (personaInputDTO == null) return;
        id_persona = personaInputDTO.getId_persona();
        usuario = personaInputDTO.getUsuario();
        password = personaInputDTO.getPassword();
        name = personaInputDTO.getName();
        surname = personaInputDTO.getSurname();
        company_email = personaInputDTO.getCompany_email();
        personal_email = personaInputDTO.getPersonal_email();
        city = personaInputDTO.getCity();
        active = personaInputDTO.getActive();
        created_date = personaInputDTO.getCreated_date();
        imagen_url = personaInputDTO.getImagen_url();
        termination_date = personaInputDTO.getTermination_date();
        admin = personaInputDTO.isAdmin();
    }
}