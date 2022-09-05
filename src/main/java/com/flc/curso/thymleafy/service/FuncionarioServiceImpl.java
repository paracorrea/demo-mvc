package com.flc.curso.thymleafy.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flc.curso.thymleafy.dao.FuncionarioDao;
import com.flc.curso.thymleafy.domain.Funcionario;

@Transactional(readOnly = true)
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired 
	private FuncionarioDao dao;
	
	@Override @Transactional(readOnly = false)
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
		
	}

	@Override @Transactional(readOnly = false)
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Override @Transactional(readOnly = false)
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Funcionario buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean funcionarioTemCargo(Long id) {
		
		/*
		 * if (buscarPorId(id).getCargo()) { return false; } return true;
		 */
		return false;
		
			}

	@Override
	public List<Funcionario> BuscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return dao.findByNome(nome);
	}

	
	
}
