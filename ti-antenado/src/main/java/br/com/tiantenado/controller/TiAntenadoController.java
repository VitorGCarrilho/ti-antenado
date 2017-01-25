package br.com.tiantenado.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tiantenado.model.Curso;
import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.repository.CursoRepository;
import br.com.tiantenado.repository.UsuarioRepository;
import br.com.tiantenado.service.CursoService;

@Controller
public class TiAntenadoController {

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/home")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("index");
		List<Curso> cursos = cursoService.getAllInCurrentModule();		
		mv.addObject("cursos", cursos);
		return mv;
	}

	
	@RequestMapping("/informacaocursos")
	public String informacaocursos(){		
		return "InformacaoCursos";
	}
	@RequestMapping("/usuario")
	public String inserirUsuario(){		
		return "InserirUsuario";
	}
	@RequestMapping("/curso/{id}")
	public ModelAndView curso(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("DetalhesCurso");
		//Curso curso = cursosRepository.findOne(id);
		//mv.addObject("curso", curso);
		return mv;
	}
	
	
	
}
