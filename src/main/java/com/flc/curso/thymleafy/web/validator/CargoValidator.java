package com.flc.curso.thymleafy.web.validator;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.flc.curso.thymleafy.domain.Cargo;
import com.flc.curso.thymleafy.service.CargoService;




public class CargoValidator implements Validator {

	CargoService cargoService;
	
	@Autowired
	public CargoValidator(CargoService cargoService) {
		this.cargoService=cargoService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Cargo.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		Cargo c = (Cargo) object;
			
	
		String nome = c.getNome();
		List<Cargo> cargos = cargoService.buscarPorNome(nome);  
		
		if (nome != null) {
			if (cargos.size() > 0 ) {
			errors.rejectValue("nome", "CargoJaExiste.cargo.nome");
		}
		}

	}

}
