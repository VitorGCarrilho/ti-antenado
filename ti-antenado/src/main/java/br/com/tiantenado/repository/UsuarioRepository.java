package br.com.tiantenado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.tiantenado.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("select u from Usuario u where u.cdUsuario = (select c.professor.cdUsuario from Curso c where cdCurso = ?)")
	Usuario findProfessorByCurso(long id);
}
