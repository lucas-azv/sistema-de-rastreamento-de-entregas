package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.dto.PacoteDTO;
import br.edu.iftm.rastreamento.service.PacoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/pacotes")
@Tag(name = "Pacotes", description = "API de pacotes")
public class PacoteController {

	@Autowired
	private PacoteService pacoteService;

	@Operation(summary = "Retorna todos os pacotes")
	@GetMapping
	public List<PacoteDTO> getAllPacotes() {
		return pacoteService.getAllPacotes();
	}

	@Operation(summary = "Retorna um pacote pelo ID")
	@GetMapping("/{id}")
	public PacoteDTO getPacoteById(@PathVariable Long id) {
		PacoteDTO pacoteDTO = pacoteService.getPacoteById(id);
		return pacoteDTO;
	}

	@Operation(summary = "Cria um novo pacote", description = "Retorna o pacote criado")
	@PostMapping
	public PacoteDTO createPacote(@RequestBody PacoteDTO pacoteDTO) {
		return pacoteService.createPacote(pacoteDTO);
	}

	@Operation(summary = "Atualiza um pacote pelo ID", description = "Retorna o pacote atualizado")
	@PutMapping("/{id}")
	public PacoteDTO updatePacote(@PathVariable Long id, @RequestBody PacoteDTO pacoteDTO) {
		PacoteDTO updatedPacote = pacoteService.updatePacote(id, pacoteDTO);
		return updatedPacote;
	}
}