package com.cursos.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.cursos.model")
@EnableJpaRepositories(basePackages = "com.cursos.repository")
@SpringBootApplication(scanBasePackages = {"com.cursos.controller", "com.cursos.service"})
public class CursosCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosCrudApplication.class, args);
	}

}
