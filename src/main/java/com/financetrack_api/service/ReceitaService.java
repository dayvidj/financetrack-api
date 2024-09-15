package com.financetrack_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financetrack_api.dto.ReceitaDTO;
import com.financetrack_api.exception.EntidadeDuplicadaException;
import com.financetrack_api.exception.ObjetoNaoEncontradoException;
import com.financetrack_api.model.Receita;
import com.financetrack_api.repository.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository repository;
	
	@Transactional
	public void salvar(ReceitaDTO dados) {
		if(repository.existsByDescricao(dados.descricao())) {
			throw new EntidadeDuplicadaException("Receita duplicada");
		}
		repository.save(new Receita(dados));
	}
	
	@Transactional(readOnly = true)
	public List<ReceitaDTO> listar() {
		var receitas = repository.findAll().stream().map(ReceitaDTO::new).toList();
		return receitas;			
	}
	
	@Transactional(readOnly = true)
	public ReceitaDTO detalhar(Long id) {
		var receita = repository.findById(id)
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Receita não encontrada com ID: "+id));
		return new ReceitaDTO(receita);
	}
	
	@Transactional
	public ReceitaDTO atualizar(Long id, ReceitaDTO dadosReceita) {
		System.out.println("teste");
		var receita = repository.findById(id)
				.orElseThrow(() -> new ObjetoNaoEncontradoException("Receita não encontrada com ID: "+id));	
		
		receita.atualizarDados(dadosReceita);
		repository.save(receita);
		
		return new ReceitaDTO(receita);
	}
	
	@Transactional
	public String deletar(Long id) {
		if(!repository.existsById(id)) {
			throw new ObjetoNaoEncontradoException("Receita não encontrada com ID: "+id);
		}
		
		repository.deleteById(id);
		return "Receita deletada com sucesso";
	}
	
}
