package com.bosonit;

import com.bosonit.storage.application.port.StoragePort;
import com.bosonit.storage.properties.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Sa2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sa2Application.class, args);
	}

	@Bean
	CommandLineRunner init(StoragePort storagePort) {
		return (args) -> {
			storagePort.deleteAll();
			storagePort.init();
		};
	}
}
