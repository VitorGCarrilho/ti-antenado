package br.com.tiantenado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tiantenado.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
