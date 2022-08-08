package com.bosonit.persona.application;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.domain.PersonaEntity_;
import com.bosonit.persona.exception.NotFoundException;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaProfesorOutputDTO;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaStudentOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.bosonit.persona.infrastructure.controller.ReadPersonaController.*;

@Service
public class ReadPersonaUseCase implements ReadPersonaPort {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO getPersonaByID(String id, String outputType) throws Exception {
        switch (outputType) {
            case "persona":
                PersonaEntity personaEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado la Persona con el ID: " + id));
                return new PersonaOutputDTO(personaEntity);

            case "profesor":
                PersonaEntity personaProfesorEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado la Persona con el ID: " + id));
                return new PersonaOutputDTO(personaProfesorEntity);

            case "student":
                PersonaEntity personaStudentEntity = personaRepository.findById(id).orElseThrow(() -> new Exception("No se ha encontrado al Student con el ID: " + id));
                return new PersonaStudentOutputDTO(personaStudentEntity);
        }

        return new PersonaOutputDTO(new PersonaEntity());
    }

    @Override
    public List getAllUsuarios(String outputType) {
        switch (outputType) {
            case "persona":
                List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
                personaRepository.findAll().forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
                return personaOutputDTOList;

            case "profesor":
                List<PersonaProfesorOutputDTO> personaProfesorOutputDTOSList = new ArrayList<>();
                personaRepository.findAll().forEach((personaEntity -> personaProfesorOutputDTOSList.add(new PersonaProfesorOutputDTO(personaEntity))));
                return personaProfesorOutputDTOSList;

            case "student":
                List<PersonaStudentOutputDTO> personaStudentOutputDTOList = new ArrayList<>();
                personaRepository.findAll().forEach(personaEntity -> personaStudentOutputDTOList.add(new PersonaStudentOutputDTO(personaEntity)));
                return personaStudentOutputDTOList;
        }

        return new ArrayList<>();
    }

    @Override
    public List getPersonaByName(String name, String outputType) {
        switch (outputType) {
            case "persona":
                List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
                personaRepository.findByName(name).forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
                return personaOutputDTOList;

            case "profesor":
                List<PersonaProfesorOutputDTO> personaProfesorOutputDTOList = new ArrayList<>();
                personaRepository.findByName("profesor").forEach(personaEntity -> personaProfesorOutputDTOList.add(new PersonaProfesorOutputDTO(personaEntity)));
                return personaProfesorOutputDTOList;

            case "student":
                List<PersonaStudentOutputDTO> personaStudentOutputDTOList = new ArrayList<>();
                personaRepository.findByName("student").forEach(personaEntity -> personaStudentOutputDTOList.add(new PersonaStudentOutputDTO(personaEntity)));
                return personaStudentOutputDTOList;
        }

        return new ArrayList<>();
    }

    @Override
    public List<PersonaOutputDTO> getDataOrderByField(HashMap<String, Object> conditions, String outputType, Integer page, Integer maxResult) throws Exception {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntity> criteriaQuery = criteriaBuilder.createQuery(PersonaEntity.class);
        Root<PersonaEntity> personaEntityRoot = criteriaQuery.from(PersonaEntity.class);

        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();
        List<Predicate> predicateList = new ArrayList<>();
        conditions.forEach((field, value) -> {

            switch (field) {
                case "usuario":
                    predicateList.add(criteriaBuilder.like(personaEntityRoot.get(field), "%" + value + "%"));
                    break;

                case "name":
                    predicateList.add(criteriaBuilder.like(personaEntityRoot.get(field), "%" + value + "%"));

                case "surname":
                    predicateList.add(criteriaBuilder.like(personaEntityRoot.get(field), "%" + value + "%"));
                    break;

                case "created_date":
                    String dateCondition = String.valueOf(conditions.get("dateCondition"));

                    switch (dateCondition) {
                        case GREATER_THAN ->
                                predicateList.add(criteriaBuilder.greaterThan(personaEntityRoot.get(field), (Date) value));

                        case LESS_THAN ->
                                predicateList.add(criteriaBuilder.lessThan(personaEntityRoot.get(field), (Date) value));

                        case EQUAL ->
                                predicateList.add(criteriaBuilder.equal(personaEntityRoot.<Date>get(field), value));
                    }

                    break;
            }

        });

        TypedQuery<PersonaEntity> personaEntityTypedQuery = null;

        if (outputType != null) {
            switch (outputType) {
                case "usuario":
                    criteriaQuery.orderBy(criteriaBuilder.desc(personaEntityRoot.get(PersonaEntity_.USUARIO)));
                    personaEntityTypedQuery = entityManager.createQuery(criteriaQuery);
                    break;

                case "name":
                    outputType.equals(criteriaQuery.orderBy(criteriaBuilder.desc(personaEntityRoot.get(PersonaEntity_.NAME))));
                    personaEntityTypedQuery = entityManager.createQuery(criteriaQuery);
                    break;
            }

        }

        if (page <= 0) throw new NotFoundException("Introduce una pagina superior a 0");
        personaEntityTypedQuery = entityManager.createQuery(criteriaQuery);
        personaEntityTypedQuery.setFirstResult(page - 1).setMaxResults(maxResult).getResultList().forEach(personaEntity -> personaOutputDTOList.add(new PersonaOutputDTO(personaEntity)));
        return personaOutputDTOList;
    }

}