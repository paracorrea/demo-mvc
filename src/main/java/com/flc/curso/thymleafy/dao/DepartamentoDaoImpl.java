package com.flc.curso.thymleafy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flc.curso.thymleafy.domain.Departamento;
@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {

	@Override
	public List<Departamento> findByName(String nome) {
		
		return createQuery("select f from Departamento f where f.nome like concat('%',?1, '%' ) ",nome);
	}

}
