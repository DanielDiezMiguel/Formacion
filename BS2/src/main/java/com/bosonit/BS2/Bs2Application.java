package com.bosonit.BS2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bs2Application {
    public static void main(String[] args) {
        SpringApplication.run(Bs2Application.class, args);

    }
    @Bean
    @Qualifier("getDataPersona")
    public PersonaService getPersonaService() {
        PersonaService personaService = new PersonaServiceImpl();
        return personaService;

    }
    @Bean
    @Qualifier("bean1Qualifier")
    public PersonaService getPersonaServiceBean1() {
        PersonaService pS1 = new PersonaServiceImpl();
        pS1.setNombre("bean1");
        return pS1;
    }

    @Bean
    @Qualifier("bean2Qualifier")
    public PersonaService getPersonaServiceBean2() {
        PersonaService pS2 = new PersonaServiceImpl();
        pS2.setNombre("bean2");
        return pS2;
    }

    @Bean
    @Qualifier("bean3Qualifier")
    public PersonaService getPersonaServiceBean3() {
        PersonaService pS3 = new PersonaServiceImpl();
        pS3.setNombre("bean3");
        return pS3;
    }

    @Bean
    @Qualifier("bean4Qualifier")
    public PersonaService getPersonaServiceBean4() {
        PersonaService pS4 = new PersonaServiceImpl();
        pS4.setNombre("Parámetro incorrecto");
        return pS4;
    }

}
