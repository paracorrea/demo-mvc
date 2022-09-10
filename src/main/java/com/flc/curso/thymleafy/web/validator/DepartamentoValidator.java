package com.flc.curso.thymleafy.web.validator;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.flc.curso.thymleafy.domain.Departamento;
import com.flc.curso.thymleafy.service.DepartamentoService;




public class DepartamentoValidator implements Validator {

	DepartamentoService departamentoService;
	
	@Autowired
	public DepartamentoValidator(DepartamentoService departamentoService) {
		this.departamentoService=departamentoService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Departamento.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Departamento d = (Departamento) object;
			
	
		String nome = d.getNome();
		List<Departamento> departamentos = departamentoService.buscarPorNome(nome);  
		
		if (nome != null) {
			if (departamentos.size() > 0 ) {
			errors.rejectValue("nome", "DepartamentoJaExiste.departamento.nome");
		}
		}

	}

}
