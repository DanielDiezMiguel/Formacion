package com.bosonit.BS41Perfiles;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Bs41PerfilesApplication {


    public static void main(String[] args) {
        SpringApplication.run(Bs41PerfilesApplication.class, args);
    }

    @Bean
    @Qualifier("applicationconfigbean")
    public ApplicationConfig getApplicaitonConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();

        return applicationConfig;
    }

    @Bean
    @Qualifier("miconfiguracionbean")
    public MiConfiguracion getMiConfiguracion() {
        MiConfiguracion miConfiguracion = new MiConfiguracion();

        return miConfiguracion;
    }

}
