package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class Ej05ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ej05ConfigServerApplication.class, args);
	}

}
