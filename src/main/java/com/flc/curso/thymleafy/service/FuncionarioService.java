package com.flc.curso.thymleafy.service;

import java.util.List;

import com.flc.curso.thymleafy.domain.Funcionario;

public interface FuncionarioService {

	
	void salvar(Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();
	
	boolean funcionarioTemCargo(Long id);
}

