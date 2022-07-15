package com.bosonit.BS4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import javax.annotation.PostConstruct;

@ConfigurationPropertiesScan
@SpringBootApplication
public class Bs4Application {

	@Autowired
	private ConfigurationProperties configurationProperties;

	public static void main(String[] args) {
		SpringApplication.run(Bs4Application.class, args);
	}

	@PostConstruct
	private void getVarProperties(){
		System.out.println(configurationProperties);
	}

}
