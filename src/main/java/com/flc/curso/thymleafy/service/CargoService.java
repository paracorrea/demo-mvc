package com.flc.curso.thymleafy.service;

import java.util.List;

import com.flc.curso.thymleafy.domain.Cargo;

public interface CargoService {

	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();
	
	List<Cargo> buscarPorNome(String nome);

	boolean cargoTemFuncionarios(Long id);
	
}
