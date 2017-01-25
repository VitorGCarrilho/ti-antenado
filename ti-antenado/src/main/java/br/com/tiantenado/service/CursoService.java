package br.com.tiantenado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiantenado.model.Curso;
import br.com.tiantenado.repository.CursoRepository;
import br.com.tiantenado.repository.UsuarioRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	
	public List<Curso> getAllInCurrentModule(){
		return cursoRepository.findAllInCurrentModule();
	}
	
	public Curso findById(long id){
		return cursoRepository.findOne(id);
	}
}
