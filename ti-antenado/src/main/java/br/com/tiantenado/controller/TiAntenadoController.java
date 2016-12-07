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

@Controller
public class TiAntenadoController {

	@Autowired
	private CursoRepository cursos;
	
	@RequestMapping("/home")
	public String home(){
		List<Curso> cursosList = cursos.findAll();
		for(Curso curso : cursosList){
			System.out.println(curso.getNmCurso());
			Usuario professor = curso.getProfessor();
			System.out.println(professor.getNmUsuario());
		}
		
		
		return "index";
	}
	
}
