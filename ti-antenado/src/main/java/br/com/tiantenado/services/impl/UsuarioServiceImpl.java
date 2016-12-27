package br.com.tiantenado.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.repository.UsuarioRepository;
import br.com.tiantenado.services.UsuarioService;

@Service
public class UsuarioServiceImpl extends BasicPersistenceServiceImpl<Usuario, Long> implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public JpaRepository<Usuario, Long> getRepository() {

		return usuarioRepository;
	}

}
