package com.bosonit;

import com.bosonit.application.DeletePersonaUserCase;
import com.bosonit.application.UpdatePersonaUseCase;
import com.bosonit.application.port.DeletePersonaPort;
import com.bosonit.application.port.UpdatePersonaPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bp1ArquitecturaHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bp1ArquitecturaHexagonalApplication.class, args);
	}
}
