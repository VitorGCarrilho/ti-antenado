package br.com.tiantenado.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.tiantenado.model.Curso;
import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.repository.CursoRepository;
import br.com.tiantenado.repository.UsuarioRepository;
import br.com.tiantenado.service.CursoService;
import br.com.tiantenado.service.EmailService;

@Controller
public class TiAntenadoController {

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/")
	public String home1 (){
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("index");
		List<Curso> cursos = cursoService.getAllInCurrentModule();		
		mv.addObject("cursos", cursos);
		mv.addObject("usuario",new Usuario());
		return mv;
	}
}
