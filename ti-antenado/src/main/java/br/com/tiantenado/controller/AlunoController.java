package br.com.tiantenado.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.tiantenado.model.Usuario;

@Controller
@RequestMapping("alunos")
public class AlunoController {
	
	@RequestMapping(value="cadastro", method=RequestMethod.POST)
	public ModelAndView inserirUsuario(Usuario usuario){	
		System.out.println("metodo chamado: usuario "+ usuario.getNmUsuario());
		ModelAndView mv = new ModelAndView("Usuario/InserirAluno");
		mv.addObject("usuario",usuario);
		return mv;
	}
	
	@RequestMapping("cadastro")
	public ModelAndView inserirUsuario(){		
		Usuario usuario = new Usuario();
		ModelAndView mv = new ModelAndView("Usuario/InserirAluno");
		mv.addObject("usuario",usuario);
		return mv;
	}
}
