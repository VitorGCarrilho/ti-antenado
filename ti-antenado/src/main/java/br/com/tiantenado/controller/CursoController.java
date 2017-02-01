package br.com.tiantenado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tiantenado.model.Curso;
import br.com.tiantenado.service.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping("")
	public ModelAndView cursos(){	
		ModelAndView mv = new ModelAndView("Curso/Cursos");
		List<Curso> cursos = cursoService.getAllInCurrentModule();
		mv.addObject("cursos",cursos);
		return mv;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView curso(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("Curso/DetalhesCurso");
		Curso curso = cursoService.findById(id);
		mv.addObject("curso", curso);
		return mv;
	}

}
