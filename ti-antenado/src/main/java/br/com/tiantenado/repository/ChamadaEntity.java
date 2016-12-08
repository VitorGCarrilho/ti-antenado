package br.com.tiantenado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tiantenado.model.Chamada;

public interface ChamadaEntity extends JpaRepository<Chamada, Long>{

}
