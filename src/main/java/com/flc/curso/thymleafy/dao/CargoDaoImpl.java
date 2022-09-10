package com.flc.curso.thymleafy.dao;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.flc.curso.thymleafy.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao{

	@Override
	public List<Cargo> findByNome(String nome) {
		return createQuery("select f from Cargo f where f.nome like concat('%',?1, '%' ) ",nome);
		
	}

	


	

	

}
