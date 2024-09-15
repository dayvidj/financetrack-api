package com.financetrack_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.financetrack_api.model.Receita;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ReceitaDTO(
		@NotBlank
		String descricao, 
		
		@NotNull
		@Positive
		BigDecimal valor, 
		
		@NotNull
		LocalDate data) {
	
	public ReceitaDTO(Receita dadosReceita) {
		this(dadosReceita.getDescricao(), dadosReceita.getValor(), dadosReceita.getData());
	}

}
