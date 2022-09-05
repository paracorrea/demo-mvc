package com.flc.curso.thymleafy.dao;

import java.util.List;


import com.flc.curso.thymleafy.domain.Funcionario;

public interface FuncionarioDao {
	
	void save(Funcionario Funcionario);
	 
	 void update(Funcionario Funcionario);
	 
	 void delete(Long id);
	 
	 Funcionario findById(Long id);
	 
	List<Funcionario> findAll();

	List<Funcionario> findByNome(String nome);
}
