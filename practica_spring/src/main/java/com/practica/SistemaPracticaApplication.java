package com.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;




@EnableCaching
@SpringBootApplication
public class SistemaPracticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPracticaApplication.class, args);
	}
	}
