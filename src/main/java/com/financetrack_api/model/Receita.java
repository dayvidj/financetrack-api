package com.financetrack_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.financetrack_api.dto.ReceitaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "receitas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private BigDecimal valor;
	private LocalDate data;
	
	public Receita(ReceitaDTO dados) {
		descricao = dados.descricao();
		valor = dados.valor();
		data = dados.data();
	}

}
