package br.com.tiantenado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tiantenado.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
