package com.bosonit;

import com.bosonit.persona.application.port.ReadPersonaPort;
import com.bosonit.persona.domain.PersonaEntity;
import com.bosonit.persona.infrastructure.controller.CreatePersonaController;
import com.bosonit.persona.infrastructure.controller.ReadPersonaController;
import com.bosonit.persona.infrastructure.controller.dto.output.PersonaOutputDTO;
import com.bosonit.persona.infrastructure.repository.jpa.PersonaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EJTE1ApplicationTests {

    @Mock
    PersonaRepository personaRepository;

    @InjectMocks
    CreatePersonaController createPersonaController;

    @InjectMocks
    ReadPersonaController readPersonaController;

    @BeforeTestClass
    public void putWhen() {
        Mockito.when(personaRepository.findAll()).thenReturn(new ArrayList<PersonaEntity>());
    }

    @Test
    public void getAllPersonas() {
        List<PersonaOutputDTO> personaEntitiesList = readPersonaController.getAllPersonas();
        Assertions.assertEquals(0, personaEntitiesList.size());
    }
}