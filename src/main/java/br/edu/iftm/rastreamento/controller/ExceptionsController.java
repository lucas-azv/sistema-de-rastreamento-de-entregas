package br.edu.iftm.rastreamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.iftm.rastreamento.service.exceptions.NaoAcheiException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@ControllerAdvice
@Tag(name = "Exceptions", description = "API de tratamento de exceções")
public class ExceptionsController {

	@Operation(summary = "Trata exceção de não encontrado")
	@ExceptionHandler(NaoAcheiException.class)
	public ResponseEntity<?> naoAchei(NaoAcheiException e) {
		System.out.println("------------------------");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
}
