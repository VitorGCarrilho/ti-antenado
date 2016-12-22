package br.com.tiantenado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tiantenado.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


}
