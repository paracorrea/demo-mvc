package com.flc.curso.thymleafy.service;

import java.util.List;

import com.flc.curso.thymleafy.domain.Departamento;

public interface DepartamentoService {
	void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();
	
	List<Departamento> buscarPorNome(String nome);

	boolean departamentoTemCargos(Long id);
	
}
