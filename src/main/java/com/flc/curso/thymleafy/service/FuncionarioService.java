package com.flc.curso.thymleafy.service;

import java.time.LocalDate;
import java.util.List;

import com.flc.curso.thymleafy.domain.Funcionario;

public interface FuncionarioService {

	
	void salvar(Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();
	
	boolean funcionarioTemCargo(Long id);

	List<Funcionario> BuscarPorNome(String nome);

	List<Funcionario> BuscarPorCargo(Long id);

	List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida);
}

