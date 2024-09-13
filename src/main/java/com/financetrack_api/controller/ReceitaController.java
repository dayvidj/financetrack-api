package com.financetrack_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financetrack_api.dto.ReceitaDTO;
import com.financetrack_api.service.ReceitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

	@Autowired
	private ReceitaService service;

	@PostMapping
	public ResponseEntity cadastrarReceita(@RequestBody @Valid ReceitaDTO dados) {
		service.salvar(dados);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity listarReceitas() {
		return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity detalharReceita(@PathVariable Long id) {
		return ResponseEntity.ok(service.detalhar(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity atiualizarReceita(@PathVariable Long id, ReceitaDTO dados) {
		return ResponseEntity.ok(service.atualizar(id, dados));
	}

	@DeleteMapping
	public ResponseEntity excluirReceita(@PathVariable Long id) {
		return ResponseEntity.ok(service.deletar(id));
	}

}
