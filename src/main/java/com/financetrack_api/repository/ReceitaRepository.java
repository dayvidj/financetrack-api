package com.financetrack_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financetrack_api.model.Receita;

import jakarta.validation.constraints.NotBlank;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	
	boolean existsByDescricao(@NotBlank String descricao);

}
