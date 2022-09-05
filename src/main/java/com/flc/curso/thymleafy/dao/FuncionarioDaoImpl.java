package com.flc.curso.thymleafy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flc.curso.thymleafy.domain.Funcionario;
@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	@Override
	public List<Funcionario> findByNome(String nome) {
		
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1, '%' ) ",nome);
	}

}
