package com.bosonit.Mapping;

import com.bosonit.Mapping.application.port.PersonaMapper;
import com.bosonit.Mapping.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappingApplication {

  public static void main(String[] args) {
    SpringApplication.run(MappingApplication.class, args);
  }
}
