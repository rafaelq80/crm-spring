package com.generation.crm_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.crm_spring.model.Oportunidade;


public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long>{
	
    List<Oportunidade> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
    
}