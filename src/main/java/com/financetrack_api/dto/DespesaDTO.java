package com.financetrack_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.financetrack_api.model.Categoria;
import com.financetrack_api.model.Despesa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DespesaDTO(
		@NotBlank 
		String descricao, 
		
		@NotNull 
		@Positive 
		BigDecimal valor, 
		
		@NotNull 
		LocalDate data, 
		
		Categoria categoria) {

	public DespesaDTO(Despesa despesa) {
		this(despesa.getDescricao(), despesa.getValor(), despesa.getData(), despesa.getCategoria());
	}
	
}
