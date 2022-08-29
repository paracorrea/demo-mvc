package com.flc.curso.thymleafy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.curso.thymleafy.dao.DepartamentoDao;
import com.flc.curso.thymleafy.domain.Departamento;

@Service @Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

	
	private DepartamentoDao dao;
	@Override
	public void salvar(Departamento departamento) {
		dao.save(departamento);
		
	}

	@Override
	public void editar(Departamento departamento) {
		dao.update(departamento);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	

}
