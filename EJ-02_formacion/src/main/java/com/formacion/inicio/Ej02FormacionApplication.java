package com.formacion.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.formacion.controller", "com.formacion.service"})
public class Ej02FormacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ej02FormacionApplication.class, args);
	}

    @Bean
    RestTemplate template() {
        return new RestTemplate();
    }
}
