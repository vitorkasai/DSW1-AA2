package br.ufscar.dc.dsw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.security.LocadoraDetails;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.IUsuarioService;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Controller
@RequestMapping("/locacoes")
public class LocacaoController {
	@Autowired
	private ILocacaoService serviceLocacao;

	@Autowired
	private ILocadoraService serviceLocadora;

	@ModelAttribute("horasDisponiveis")
	public List<String> popularHorasDisponiveis() {
		// Crie a lista de horários disponíveis
		List<String> horasDisponiveis = new ArrayList<>();
		for (int hora = 0; hora < 24; hora++) {
			String horaStr = String.format("%02d:00:00", hora);
			horasDisponiveis.add(horaStr);
		}

		return horasDisponiveis;
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Locacao locacao, ModelMap model) {
		locacao.setUsuario(this.getUsuario());
		model.addAttribute("horariosDisponiveis", popularHorasDisponiveis());
		System.out.println("Passei por /locacoes/cadastrar");
		model.addAttribute("locadoras", serviceLocadora.buscarTodos());
		return "locacao/cadastro";
	}

	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}


	@PostMapping("/salvar")
	public String salvar(Locacao locacao, BindingResult result, RedirectAttributes attr) {
		System.out.println("Passei por /locacoes/salvar");
		serviceLocacao.salvar(locacao);
		attr.addFlashAttribute("sucess", "Locação inserida com sucesso.");
		return "user/index";
	}

	@GetMapping("/listar")
	public String listar(Usuario usuario, ModelMap model) {
		usuario = getUsuario();
		model.addAttribute("locacoes",serviceLocacao.buscarTodosUsuario(usuario));
		return "locacao/lista";
	}

}
