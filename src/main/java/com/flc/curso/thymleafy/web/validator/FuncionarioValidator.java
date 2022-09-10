package com.flc.curso.thymleafy.web.validator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.flc.curso.thymleafy.domain.Funcionario;
import com.flc.curso.thymleafy.service.FuncionarioService;



public class FuncionarioValidator implements Validator {

	FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioValidator(FuncionarioService funcionarioService) {
		this.funcionarioService=funcionarioService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Funcionario f = (Funcionario) object;
		
		LocalDate entrada = f.getDataEntrada();
		
		if (f.getDataSaida() != null) {
			if (f.getDataSaida().isBefore(entrada)) {
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
			}
		}
		
	
		String nome = f.getNome();
		List<Funcionario> funcionarios = funcionarioService.BuscarPorNome(nome);  
		
		if (nome != null) {
			if (funcionarios.size() > 0 ) {
			System.out.println("Passou aqui");	
			errors.rejectValue("nome", "NomeJaExiste.funcionario.nome");
		}
		}

	}

}
