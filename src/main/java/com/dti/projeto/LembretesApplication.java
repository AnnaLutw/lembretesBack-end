package com.dti.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
* Classe onde o projeto irá iniciar
* */
@SpringBootApplication
public class LembretesApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/lembretes/**").allowedOrigins("*");
			}
		};
	}
	//Main onde vai começar o projeto
	public static void main(String[] args) {
		SpringApplication.run(LembretesApplication.class, args);


	}

}
