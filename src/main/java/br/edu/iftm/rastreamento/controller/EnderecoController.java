package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.rastreamento.dto.EnderecoDTO;
import br.edu.iftm.rastreamento.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/enderecos")
@Tag(name = "Endereços", description = "API de endereços")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@Operation(summary = "Retorna todos os endereços")
	@GetMapping
	public List<EnderecoDTO> getAllEnderecos() {
		return enderecoService.getAllEnderecos();
	}

	@Operation(summary = "Retorna um endereço pelo ID")
	@GetMapping("/{id}")
	public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable Long id) {
		EnderecoDTO enderecoDTO = enderecoService.getEnderecoById(id);
		return ResponseEntity.ok(enderecoDTO);
	}

	@Operation(summary = "Cria um novo endereço", description = "Retorna o endereço criado")
	@PostMapping
	public EnderecoDTO createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
		return enderecoService.createEndereco(enderecoDTO);
	}

	@Operation(summary = "Atualiza um endereço pelo ID", description = "Retorna o endereço atualizado")
	@PutMapping("/{id}")
	public EnderecoDTO updateEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO) {
		EnderecoDTO updatedEndereco = enderecoService.updateEndereco(id, enderecoDTO);
		return updatedEndereco;
	}
}