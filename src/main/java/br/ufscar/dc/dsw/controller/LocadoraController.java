package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Controller
@RequestMapping("/locadoras")
public class LocadoraController {
	
	@Autowired
	private ILocadoraService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Locadora locadora) {
		System.out.println("Passei por /locadoras/cadastrar");
		return "locadora/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("locadoras",service.buscarTodos());
		return "admin/crud_locadoras";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locadora/cadastro";
		}

		System.out.println("password = " + locadora.getPassword());
		
		locadora.setPassword(encoder.encode(locadora.getPassword()));
		service.salvar(locadora);
		attr.addFlashAttribute("sucess", "Locadora inserida com sucesso.");
		return "redirect:/admin/crud-locadoras";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		System.out.println("Passei por /locadoras/editar/id especifico");
		model.addAttribute("locadora", service.buscarPorId(id));
		return "locadora/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		
		System.out.println("Passei por /locadoras/editar");

		if (result.hasErrors()) {
			return "locadora/cadastro";
		}

		System.out.println(locadora.getPassword());
		
		service.salvar(locadora);
		attr.addFlashAttribute("sucess", "Locadora editada com sucesso.");
		return "redirect:/locadoras/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("sucess", "Locadora excluída com sucesso.");
		return listar(model);
	}
}