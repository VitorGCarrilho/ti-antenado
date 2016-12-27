package br.com.tiantenado.controller;

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

@Controller
public class TiAntenadoController {

	@Autowired
	private CursoRepository cursosRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/home")
	public String home(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		for(Usuario usuario : usuarios){
			System.out.println(usuario.getNmUsuario());
			List<Curso> cursos = usuario.getCursos();
			for (Curso curso : cursos){
				System.out.println(curso.getNmCurso());
			}
		}
		
		
		return "home/index";
	}
	@RequestMapping("/curso")
	public ModelAndView listaCursos(){
		ModelAndView mv = new ModelAndView("PesquisaCursos");
		List<Curso> cursos = cursosRepository.findAll();
		mv.addObject("cursos",cursos);
		
		return mv;
	}
	@RequestMapping("/usuario")
	public String inserirUsuario(){		
		return "InserirUsuario";
	}
	@RequestMapping("/curso/{id}")
	public ModelAndView curso(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("DetalhesCurso");
		Curso curso = cursosRepository.findOne(id);
		mv.addObject("curso", curso);
		return mv;
	}
	
	
	
}
