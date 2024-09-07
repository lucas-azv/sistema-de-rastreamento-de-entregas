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

import br.edu.iftm.rastreamento.dto.RastreamentoDTO;
import br.edu.iftm.rastreamento.service.RastreamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rastreamentos")
@Tag(name = "Rastreamentos", description = "API de rastreamentos")
public class RastreamentoController {

	@Autowired
	private RastreamentoService rastreamentoService;

	@Operation(summary = "Retorna todos os rastreamentos")
	@GetMapping
	public List<RastreamentoDTO> getAllRastreamentos() {
		return rastreamentoService.getAllRastreamentos();
	}

	@Operation(summary = "Retorna um rastreamento pelo ID")
	@GetMapping("/{id}")
	public RastreamentoDTO getRastreamentoById(@PathVariable Long id) {
		RastreamentoDTO rastreamentoDTO = rastreamentoService.getRastreamentoById(id);
		return rastreamentoDTO;
	}

	@Operation(summary = "Cria um novo rastreamento", description = "Retorna o rastreamento criado")
	@PostMapping
	public RastreamentoDTO createRastreamento(@RequestBody RastreamentoDTO rastreamentoDTO) {
		return rastreamentoService.createRastreamento(rastreamentoDTO);
	}

	@Operation(summary = "Atualiza um rastreamento pelo ID", description = "Retorna o rastreamento atualizado")
	@PutMapping("/{id}")
	public RastreamentoDTO updateRastreamento(@PathVariable Long id, @RequestBody RastreamentoDTO rastreamentoDTO) {
		RastreamentoDTO updatedRastreamento = rastreamentoService.updateRastreamento(id, rastreamentoDTO);
		return updatedRastreamento;
	}

}
