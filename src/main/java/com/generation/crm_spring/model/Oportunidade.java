package com.generation.crm_spring.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_oportunidades")
public class Oportunidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O Nome é Obrigatório!")
	private String nome;

	@NotNull(message = "O Valor não pode ser nulo")
	@Positive(message = "O Valor deve ser um número positivo")
	@Digits(integer = 10, fraction = 2)
	private BigDecimal valor;

	@CreationTimestamp
	private LocalDate dataAbertura;

	@NotNull(message = "A Data de Fechamento é obrigatória")
	private LocalDate dataFechamento;

	@Min(value = 1, message = "O Status deve ser um numero positivo entre 1 e 3")
	@Max(value = 3, message = "O Status deve ser um numero positivo entre 1 e 3")
	@Positive(message = "O Status deve ser um numero positivo entre 1 e 3")
	private Integer status = 1;

	@ManyToOne
	@JsonIgnoreProperties("oportunidade")
	private Cliente cliente;

	@ManyToOne
	@JsonIgnoreProperties("oportunidade")
	private Usuario usuario;

	public Oportunidade() { }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
