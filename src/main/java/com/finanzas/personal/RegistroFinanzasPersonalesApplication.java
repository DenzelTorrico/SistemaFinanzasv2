package com.finanzas.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // Reemplaza "com.finanzas.personal" con la ubicación de tu clase IngresoService
public class RegistroFinanzasPersonalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroFinanzasPersonalesApplication.class, args);
	}

}
