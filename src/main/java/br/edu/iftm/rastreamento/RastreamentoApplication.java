package br.edu.iftm.rastreamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "Rastreamento API", version = "1.0", description = "API de rastreamento de encomendas"))
@SpringBootApplication
public class RastreamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RastreamentoApplication.class, args);
	}

}
