package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteService;

@Controller
@RequestMapping("/")
public class EstudanteController {

	// TODO efetue a correção dos problemas que existem na classe Estudante Controller
	@Autowired
	private EstudanteService service;

	@GetMapping("criar")
	public String iniciarCastrado(Estudante estudante) {
		return "cadastrar-estudante";
	}

	@GetMapping()
	public String listarEstudantes(Model model) {
		model.addAttribute("estudantes", service.buscarEstudantes());
		return "index";
	}

	@PostMapping("add")
	public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "cadastrar-estudante";
		}

		service.cadastrarEstudante(estudante);

		return "redirect:";
	}

	@GetMapping("editar/{id}")
	public String exibirEdicaoEstudante(@PathVariable("id") Long id, Model model) {
		Estudante estudante = service.buscarEstudante(id);
		model.addAttribute("estudante", estudante);
		return "atualizar-estudante";
	}

	@PostMapping("atualizar/{id}")
	public String atualizarEstudante(@PathVariable("id") Long id, @Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "atualizar-estudante";
		}

        estudante.setId(id);
		service.atualizarEstudante(estudante);

		model.addAttribute("estudantes", service.buscarEstudantes());
		return "atualizado";
	}

	@GetMapping("apagar/{id}")
	public String apagarEstudante(@PathVariable("id") Long id, Model model) {
		service.deletarEstudantes(id);
		//model.addAttribute("estudantes", service.buscarEstudantes());
		return "deletado";
	}
}
