package br.com.tiantenado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tiantenado.model.TipoUsuario;
import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.repository.UsuarioRepository;

@Controller
@RequestMapping("alunos")
public class AlunoController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passWordEncoder;
	
	@RequestMapping(path="salvar",  method=RequestMethod.POST)
	public ModelAndView salvarUsuario(@Valid Usuario usuario,  BindingResult result, 
			RedirectAttributes attributes){
		Usuario user = usuarioRepository.findByDsEmail(usuario.getDsEmail());
		
		if (usuario.isValidPassword()){
			usuario.setDsSenha(this.passWordEncoder.encode(usuario.getDsSenha()));
			usuario.setTipoUsuario(TipoUsuario.A);		
			usuarioRepository.save(usuario);
		} else { 
			result.rejectValue("dsSenha", "Senhas invalidas", "Senhas invalidas");
			//return salvarUsuario(usuario, result, attributes);
		}
		
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path="salvar", method=RequestMethod.GET)
	@ResponseBody
	public String salvarUsuario(){
		return "salvo";
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
