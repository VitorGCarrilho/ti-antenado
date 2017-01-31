package br.com.tiantenado.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiantenado.model.Curso;
import br.com.tiantenado.service.CursoService;

@RestController
@RequestMapping("/api/rest/cursos")
public class CursosResources {
	
	@Autowired
	private CursoService cursoService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> getAll(){
		List<Curso> cursos = cursoService.getAllInCurrentModule();	
		if (cursos == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(cursos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(name="id") long id){
		Curso curso = cursoService.findById(id);	
		if (curso == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(curso);
	}
}
