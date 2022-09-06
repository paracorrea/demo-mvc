package com.flc.curso.thymleafy.dao;

import java.time.LocalDate;
import java.util.List;


import com.flc.curso.thymleafy.domain.Funcionario;

public interface FuncionarioDao {
	
	void save(Funcionario Funcionario);
	 
	 void update(Funcionario Funcionario);
	 
	 void delete(Long id);
	 
	 Funcionario findById(Long id);
	 
	List<Funcionario> findAll();

	List<Funcionario> findByNome(String nome);

	List<Funcionario> findByCargo(Long id);

	List<Funcionario> findByDataEntradaSaida(LocalDate entrada, LocalDate saida);

	List<Funcionario> findByDataEntrada(LocalDate entrada);

	List<Funcionario> findaByDataSaida(LocalDate saida);
}
