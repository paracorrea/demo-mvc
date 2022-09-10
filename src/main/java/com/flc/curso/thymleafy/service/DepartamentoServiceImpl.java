package com.flc.curso.thymleafy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.curso.thymleafy.dao.DepartamentoDao;
import com.flc.curso.thymleafy.domain.Departamento;

@Service 
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao dao;
	
	@Override
	@Transactional(readOnly = false)
	public void salvar(Departamento departamento) {
		dao.save(departamento);
		
	}

	@Override @Transactional(readOnly = false)
	public void editar(Departamento departamento) {
		dao.update(departamento);
		
	}

	@Override @Transactional(readOnly = false)
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

	@Override
	public boolean departamentoTemCargos(Long id) {
		if (buscarPorId(id).getCargos().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override @Transactional(readOnly = true)
	public List<Departamento> buscarPorNome(String nome) {
		return dao.findByName(nome);
	}
	

}
