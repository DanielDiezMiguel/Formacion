//package com.bosonit.Estudiante.infrastructure.controller.dto.output;
//
//import com.bosonit.Estudiante.domain.StudentEntity;
//import com.bosonit.Estudiante.infrastructure.controller.dto.input.StudentInputDTO;
//import com.bosonit.EstudianteAsignatura.domain.EstudianteAsignaturaEntity;
//import com.bosonit.Persona.domain.PersonaEntity;
//import com.bosonit.Profesor.domain.ProfesorEntity;
//import lombok.Data;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//
//@Data
//public class StudentOutputFullDTO extends StudentOutputDTO implements Serializable {
//    private String studentID;
//    private String usuario;
//    private String password;
//    private String name;
//    private String surname;
//    private String company_email;
//    private String personal_email;
//    private String city;
//    private Boolean active;
//    private Date created_date;
//    private String imagen_url;
//    private Date termination_date;
//
//
//    public StudentOutputFullDTO(PersonaEntity personaEntity) {
//        super(new StudentEntity());
//        if (personaEntity == null) return;
//        studentID = personaEntity.getStudentID().getId_student();
//        usuario = personaEntity.getUsuario();
//        password = personaEntity.getPassword();
//        name = personaEntity.getName();
//        surname = personaEntity.getSurname();
//        company_email = personaEntity.getCompany_email();
//        personal_email = personaEntity.getPersonal_email();
//        city = personaEntity.getCity();
//        active = personaEntity.getActive();
//        created_date = personaEntity.getCreated_date();
//        imagen_url = personaEntity.getImagen_url();
//        termination_date = personaEntity.getTermination_date();
//
//    }
//}
