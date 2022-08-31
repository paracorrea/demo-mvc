package com.flc.curso.thymleafy.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flc.curso.thymleafy.domain.Cargo;
import com.flc.curso.thymleafy.service.CargoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		
		model.addAttribute("cargo",service.buscarTodos() );
		return "/cargo/lista";
	}	
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo) {
		service.salvar(cargo);
		return "redirect:/cargo/cadastrar";
	}
		

	
	
}
