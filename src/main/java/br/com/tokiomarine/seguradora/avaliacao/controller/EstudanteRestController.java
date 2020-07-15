package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteService;

// TODO não esquecer de usar as anotações para criação do restcontroller
@RestController
@RequestMapping("/v1/estudantes")
public class EstudanteRestController {
	// TODO caso você não conheça THEMELEAF faça a implementação dos métodos em forma de RESTCONTROLLER (seguindo o padrão RESTFUL)
	
	@Autowired
	private EstudanteService estudanteService;
	
	// TODO IMPLEMENTAR CADASTRO DE ESTUDANTES (POST)
	@PostMapping
	public void cadastrarEstudante(@RequestBody Estudante  estudante)	{
	 	estudanteService.cadastrarEstudante(estudante);
	
	}
	
	// TODO IMPLEMENTAR ATUALIZACAO DE ESTUDANTES (PUT)
	@PutMapping(value="/{id}")
	public void atualizarEstudante(@PathVariable("id") Long id,@RequestBody Estudante  estudante)	{
		estudante.setId(id);
	 	estudanteService.atualizarEstudante(estudante);
	
	}
	
	// TODO IMPLEMENTAR A LISTAGEM DE ESTUDANTES (GET)
	@GetMapping
	public List<Estudante> buscarEstudantes() {
		return estudanteService.buscarEstudantes();
	}
	
	// TODO IMPLEMENTAR A EXCLUSÃO DE ESTUDANTES (DELETE)
	@DeleteMapping(value="/{id}")
	public void deletarEstudante(@PathVariable("id") Long id)	{
		estudanteService.deletarEstudantes(id);	
	}
	
	@GetMapping(value="/{id}")
	public Estudante buscarEstudante(@PathVariable("id") Long id)	{
	 	return estudanteService.buscarEstudante(id);
	
	}
}
