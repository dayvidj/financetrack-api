package com.financetrack_api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.financetrack_api.model.Categoria;
import com.financetrack_api.model.Despesa;

public record DespesaDTO(String descricao, BigDecimal valor, LocalDate data, Categoria categoria) {

	public DespesaDTO(Despesa despesa) {
		this(despesa.getDescricao(), despesa.getValor(), despesa.getData(), despesa.getCategoria());
	}
	
}
