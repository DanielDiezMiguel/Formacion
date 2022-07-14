package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    @Qualifier("beanQualifier1")
    public PersonaService getPersonaServiceBean1() {
        PersonaService pS1 = new PersonaServiceImpl();
        return pS1;
    }


}
