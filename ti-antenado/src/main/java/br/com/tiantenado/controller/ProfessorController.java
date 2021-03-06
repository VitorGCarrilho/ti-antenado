package br.com.tiantenado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tiantenado.exception.EmailJaCadastradoException;
import br.com.tiantenado.exception.SenhaInvalidaException;
import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.service.ProfessorService;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(path="salvar",  method=RequestMethod.POST)
	public ModelAndView salvarUsuario(@Valid Usuario usuario,  BindingResult result, 
			RedirectAttributes attributes){
		try {
			professorService.cadastrarProfessor(usuario, result, attributes);
		} catch (EmailJaCadastradoException e) {
			// ##TODO Tratar
			e.printStackTrace();
		} catch (SenhaInvalidaException e) {
			// ##TODO Tratar
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/home");
	}
	
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
