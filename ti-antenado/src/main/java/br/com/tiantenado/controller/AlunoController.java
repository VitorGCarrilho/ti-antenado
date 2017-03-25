package br.com.tiantenado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tiantenado.exception.EmailJaCadastradoException;
import br.com.tiantenado.exception.SenhaInvalidaException;
import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.service.AlunoService;

@Controller
@RequestMapping("alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(path="salvar",  method=RequestMethod.POST)
	public ModelAndView salvarUsuario(@Valid Usuario usuario,  BindingResult result, 
			RedirectAttributes attributes){
		try {
			alunoService.cadastrarAluno(usuario, result, attributes);
		} catch (EmailJaCadastradoException e) {
			// ##TODO Tratar
			e.printStackTrace();
		} catch (SenhaInvalidaException e) {
			// ##TODO Tratar
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:/home");
	}
	
	
	@RequestMapping(value="cadastro", method=RequestMethod.POST)
	public ModelAndView inserirUsuario(Usuario usuario){	
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
