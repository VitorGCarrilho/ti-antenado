package br.com.tiantenado.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.MINUTES);
		if (cursos == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(cursos);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(name="id") long id){
		Curso curso = cursoService.findById(id);	
		CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.MINUTES);
		if (curso == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(curso);
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Curso curso){
		cursoService.save(curso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return ResponseEntity.created(uri).build();
	}
}
