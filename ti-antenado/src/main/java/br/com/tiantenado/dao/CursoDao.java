package br.com.tiantenado.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiantenado.model.Curso;
import br.com.tiantenado.repository.CursoRepository;
import br.com.tiantenado.repository.UsuarioRepository;

@Service
public class CursoDao {
	@Autowired
	CursoRepository cursoRepository;
	
	public List<Curso> getAllInCurrentModule(){
		return cursoRepository.findAllInCurrentModule();
	}
}
