package com.bosonit.Log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@SpringBootApplication
public class LogApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogApplication.class, args);
	}

//	@Bean
//	void CommandLineRunner() throws IOException {
//		FileWriter fw;
//		PrintWriter pw;
//		String texto = "Prueba";
//		String path = "C:\\Users\\daniel.diez\\Documents\\GitHub\\Formacion\\Log\\src\\main\\java\\com\\bosonit\\Log\\spring-logging.log";
//		fw = new FileWriter(path, true);
//		pw = new PrintWriter(fw);
//		pw.print(log.error);
//		fw.close();
//	}

	@Bean
	void CommandLineRunner(){
		log.info("Esto es un INFO");
		log.warn("Esto es un WARN");
		log.error("Esto es un ERROR");
	}


}
