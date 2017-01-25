package br.com.tiantenado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.tiantenado.model.Curso;
import br.com.tiantenado.service.CursoService;

@RestController
@RequestMapping("/api/rest")
public class ApiController {
	
	@Autowired
	private CursoService cursoService;

	@RequestMapping("/curso")
	@JsonIgnore
	public List<Curso> getAll(){
		List<Curso> cursos = cursoService.getAllInCurrentModule();	
		return cursos;
	}
}
