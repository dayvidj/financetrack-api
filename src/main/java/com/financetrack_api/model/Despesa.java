package com.financetrack_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.financetrack_api.dto.DespesaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "despesas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	public Despesa(DespesaDTO dados) {
		this.descricao = dados.descricao();
		this.valor = dados.valor();
		this.data = dados.data();
		this.categoria = (categoria != null) ? dados.categoria() : Categoria.OUTRAS;
	}

	public void atualizarDados(DespesaDTO dados) {
		if(dados.descricao() != null && !dados.descricao().isBlank()) this.descricao = dados.descricao();
		if(dados.valor() != null) this.valor = dados.valor();
		if(dados.data() != null) this.data = dados.data();
		if(dados.categoria() != null) this.categoria = dados.categoria();
	}

}
