package com.generation.crm_spring.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome é Obrigatório!")
    private String nome;

    @NotBlank(message = "O E-mail é Obrigatório!")
	@Email(message = "O E-mail deve ser um e-mail válido!")
    private String email;

    @Size(max = 5000, message = "O Histórico não pode ser maior do que 5000 caracteres")
    private String foto;

    @Size(max = 10000, message = "O Histórico não pode ser maior do que 10000 caracteres")
    private String historico;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("cliente")
    private List<Oportunidade> oportunidade;

    public Cliente() {}
    
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public List<Oportunidade> getOportunidade() {
		return oportunidade;
	}

	public void setOportunidade(List<Oportunidade> oportunidade) {
		this.oportunidade = oportunidade;
	}

}
