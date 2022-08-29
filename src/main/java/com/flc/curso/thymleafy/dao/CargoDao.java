package com.flc.curso.thymleafy.dao;

import java.util.List;

import com.flc.curso.thymleafy.domain.Cargo;

public interface CargoDao {

	 void save(Cargo cargo);
	 
	 void update(Cargo cargo);
	 
	 void delete(Long id);
	 
	 Cargo findById(Long id);
	 
	List<Cargo> findAll();

}
