package com.bosonit.CRUD;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    @Qualifier("beanQualifier1")
    public PersonaService getPersonaServiceBean1(){
        PersonaService pS1 =  new PersonaServiceImpl();
        return pS1;
    }

    @Bean
    @Qualifier("beanQualifier2")
    public PersonaService getPersonaServiceBean2(){
        PersonaService pS2 =  new PersonaServiceImpl();
        return pS2;
    }

    @Bean
    @Qualifier("beanQualifier3")
    public PersonaService getPersonaServiceBean3(){
        PersonaService pS3 =  new PersonaServiceImpl();
        return pS3;
    }

    @Bean
    @Qualifier("beanQualifier4")
    public PersonaService getPersonaServiceBean4(){
        PersonaService pS4 =  new PersonaServiceImpl();
        return pS4;
    }
}
