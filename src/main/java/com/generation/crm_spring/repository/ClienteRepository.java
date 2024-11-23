package com.generation.crm_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.crm_spring.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public List<Cliente> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
