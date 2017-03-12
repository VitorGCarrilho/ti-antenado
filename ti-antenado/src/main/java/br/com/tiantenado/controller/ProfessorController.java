package br.com.tiantenado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tiantenado.model.Usuario;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	
	@RequestMapping("cadastro")
	public ModelAndView inserirProfessor(){
		ModelAndView mv = new ModelAndView("Usuario/InserirProfessor");
		mv.addObject("usuario",new Usuario());
		return mv;
	}
	
	@PostMapping("cadastro")
	public ModelAndView inserirUsuario(@ModelAttribute("usuario") Usuario usuario){	
		ModelAndView mv = new ModelAndView("Usuario/InserirProfessor");
		mv.addObject("usuario",usuario);
		return mv;
	}
}
