package br.com.tiantenado.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tiantenado.config.DataBaseConfig;
import br.com.tiantenado.dao.CursosDao;
import br.com.tiantenado.model.Curso;
import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.repository.CursoRepository;
import br.com.tiantenado.repository.UsuarioRepository;

@Controller
public class TiAntenadoController {

	@Autowired
	private CursoRepository cursos;
	
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
		
		
		return "index";
	}
	@RequestMapping("/curso")
	public String curso(){
		
		return "curso";
	}
	
}
