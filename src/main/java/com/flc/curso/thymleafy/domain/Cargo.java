package com.flc.curso.thymleafy.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long> {

	@NotBlank(message = "O nome do cargo é obrigatório")
	@Size(max = 60, message = "O nome do cargo deve conter no máximo 60 caracteres.")
	@Column(name ="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione o departamento relativo ao cargo")
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	private Departamento departamento;

	public String getNome() {
		return nome;
	}
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionario;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
}
