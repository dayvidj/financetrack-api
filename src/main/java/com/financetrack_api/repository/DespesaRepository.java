package com.financetrack_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.financetrack_api.model.Despesa;

import jakarta.validation.constraints.NotBlank;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	
	@Query("SELECT d FROM Despesa d WHERE d.descricao = :descricao AND MONTH(d.data) = :mes AND YEAR(d.data) = :ano")
	Optional<Despesa> findDespesaDuplicada(@Param("descricao") String descricao, @Param("mes") int mes, @Param("ano") int ano);

}
