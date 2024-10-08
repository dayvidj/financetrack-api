package com.financetrack_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.financetrack_api.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	@Query("SELECT r FROM Receita r WHERE r.descricao = :descricao AND MONTH(r.data) = :mes AND YEAR(r.data) = :ano")
	Optional<Receita> findReceitaDuplicada(@Param("descricao") String descricao, @Param("mes") int mes, @Param("ano") int ano);

	List<Receita> findByDescricaoContainingIgnoreCase(String descricao);

	@Query("SELECT r FROM Receita r WHERE YEAR(r.data) = :ano AND MONTH(r.data) = :mes")
    List<Receita> findByAnoAndMes(@Param("ano") int ano, @Param("mes") int mes); 
	
}
