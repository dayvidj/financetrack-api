package com.financetrack_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financetrack_api.model.Despesa;

import jakarta.validation.constraints.NotBlank;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	
	boolean existsByDescricao(@NotBlank String descricao);

}
