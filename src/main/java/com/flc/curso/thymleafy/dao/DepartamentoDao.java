package com.flc.curso.thymleafy.dao;

import java.util.List;


import com.flc.curso.thymleafy.domain.Departamento;

public interface DepartamentoDao {
	 
	void save(Departamento departamento);
	 
	 void update(Departamento departamento);
	 
	 void delete(Long id);
	 
	 Departamento findById(Long id);
	 
	List<Departamento> findAll();

}
