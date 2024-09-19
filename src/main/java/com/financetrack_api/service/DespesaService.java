package com.financetrack_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financetrack_api.dto.DespesaDTO;
import com.financetrack_api.exception.EntidadeDuplicadaException;
import com.financetrack_api.exception.ObjetoNaoEncontradoException;
import com.financetrack_api.model.Despesa;
import com.financetrack_api.repository.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repository;
	
	@Transactional
	public void CadastrarDespesa(DespesaDTO dados) {
		if(repository.existsByDescricao(dados.descricao())) {
			throw new EntidadeDuplicadaException("Despesa duplicada");
		}
		
		repository.save(new Despesa(dados));
	}
	
	@Transactional(readOnly = true)
	public List<DespesaDTO> listarDespesas() {
		var despesas = repository.findAll().stream().map(DespesaDTO::new).toList();
		
		return despesas;	
	}
	
	
	@Transactional(readOnly = true)
	public DespesaDTO detalharDespesa(Long id) {
		var despesa = repository.findById(id)
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Despesa não encontrada com ID: "+id));
		
		return new DespesaDTO(despesa);
	}
	
	@Transactional
	public DespesaDTO atualizarDespesa(Long id, DespesaDTO dados) {
		var despesa = repository.findById(id)
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Despesa não encontrada com ID: "+id));		
		
		despesa.atualizarDados(dados);
		repository.save(despesa);
		
		return new DespesaDTO(despesa);
	}
	
	@Transactional
	public String deletarDespesa(Long id) {
		repository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Despesa não encontrada com ID: "+id));	
		
		repository.deleteById(id);
		
		return "Despesa deletada com sucesso!";
	}
	
}
