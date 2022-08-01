package com.bosonit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Bs10Application {

	public static void main(String[] args) {
		SpringApplication.run(Bs10Application.class, args);
	}

}
