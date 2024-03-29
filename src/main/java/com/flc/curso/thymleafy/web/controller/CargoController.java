package com.flc.curso.thymleafy.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.flc.curso.thymleafy.domain.Cargo;
import com.flc.curso.thymleafy.domain.Departamento;
import com.flc.curso.thymleafy.service.CargoService;
import com.flc.curso.thymleafy.service.DepartamentoService;
import com.flc.curso.thymleafy.web.validator.CargoValidator;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	
	 @InitBinder 
	 public void initBinder(WebDataBinder binder) {
	  
		  	binder.addValidators(new CargoValidator(cargoService)); 
	  }
	 
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		
		model.addAttribute("cargos",cargoService.buscarTodos() );
		return "cargo/lista";
	}	
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo cadastrado com sucesso");
		return "redirect:/cargos/cadastrar";
	}
		

	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo, BindingResult result,RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		cargoService.editar(cargo);
		attr.addFlashAttribute("success", "Departamento editado com sucesso");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDepartamentos() {
		return departamentoService.buscarTodos();
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		
		if (cargoService.cargoTemFuncionarios(id)) {
			attr.addFlashAttribute("fail", "Cargo não removido. Possui funcionario(s) vinculado(s)");
			return "redirect:/cargos/listar";
		} else {
			cargoService.excluir(id);
			attr.addFlashAttribute("success", "Cargo removido com sucesso");		
			return "redirect:/cargos/listar";
		}
				
	}
	
}
