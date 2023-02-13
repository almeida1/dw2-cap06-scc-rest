package com.fatec.sccrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Clientes API", version = "1.0", description = "Mantem Clientes"))
public class SccrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SccrestApplication.class, args);
	}

}
