package com.financetrack_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.financetrack_api.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
	
	@Query("SELECT d FROM Despesa d WHERE d.descricao = :descricao AND MONTH(d.data) = :mes AND YEAR(d.data) = :ano")
	Optional<Despesa> findDespesaDuplicada(@Param("descricao") String descricao, @Param("mes") int mes, @Param("ano") int ano);

	List<Despesa> findByDescricaoContainingIgnoreCase(String descricao);

	@Query("SELECT d FROM Despesa d WHERE YEAR(d.data) = :ano AND MONTH(d.data) = :mes")
    List<Despesa> findByAnoAndMes(@Param("ano") int ano, @Param("mes") int mes);

}
