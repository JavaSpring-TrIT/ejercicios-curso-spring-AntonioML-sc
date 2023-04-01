package com.formacion.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.formacion.controller", "com.formacion.service"})
public class Ej02FormacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ej02FormacionApplication.class, args);
	}

	@LoadBalanced
    @Bean
    RestTemplate template() {
		BasicAuthenticationInterceptor adminInterceptor;
		adminInterceptor = new BasicAuthenticationInterceptor("user4", "user4");
		RestTemplate template = new RestTemplate();
		template.getInterceptors().add(adminInterceptor);
		return template;
	}
}
