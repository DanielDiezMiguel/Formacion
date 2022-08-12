package com.bosonit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Sa6Application {

	public static void main(String[] args) {
		SpringApplication.run(Sa6Application.class, args);
	}

}
