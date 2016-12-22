package br.com.tiantenado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tiantenado.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	List<Curso> findByNmCurso(String nmCurso);
	
	@Query("select c from Curso c where c.cdModulo = (select max(c2.cdModulo) from Curso c2)")
	List<Curso> findAllInCurrentModule();
}
