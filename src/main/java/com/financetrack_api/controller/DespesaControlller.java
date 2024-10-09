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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financetrack_api.dto.DespesaDTO;
import com.financetrack_api.service.DespesaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/despesas")
public class DespesaControlller {

	@Autowired
	private DespesaService service;
	
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DespesaDTO dados) {
		service.CadastrarDespesa(dados);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity listar(@RequestParam(required = false) String descricao) {
		return ResponseEntity.ok(service.listarDespesas(descricao));
	}

	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id) {
		return ResponseEntity.ok(service.detalharDespesa(id));
	}
	
	@GetMapping("/{ano}/{mes}")
	public ResponseEntity listarPorMes(@PathVariable int ano, @PathVariable int mes) {
		return ResponseEntity.ok(service.listarDespesasPorMes(ano, mes));
	}

	@PutMapping("/{id}")
	public ResponseEntity atualizar(@PathVariable Long id, @RequestBody DespesaDTO dados) {
		return ResponseEntity.ok(service.atualizarDespesa(id, dados));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity excluir(@PathVariable Long id) {
		return ResponseEntity.ok(service.deletarDespesa(id));
	}
	
}
