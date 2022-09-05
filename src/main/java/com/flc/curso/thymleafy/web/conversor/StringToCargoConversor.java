package com.flc.curso.thymleafy.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.flc.curso.thymleafy.domain.Cargo;
import com.flc.curso.thymleafy.service.CargoService;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

	@Autowired
	private CargoService cargoService;

	@Override
	public Cargo convert(String text) {
		if (text.isEmpty() ) {
		return null;
	}
		Long id = Long.valueOf(text);
		return cargoService.buscarPorId(id);
	}
}