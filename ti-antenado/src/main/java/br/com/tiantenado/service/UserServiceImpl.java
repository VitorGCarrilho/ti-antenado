package br.com.tiantenado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UserServiceImpl(UsuarioRepository usuarioRepository){
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario findByDsEmail(String email) {
		return usuarioRepository.findByDsEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByDsEmail(userName);
		if (usuario == null){
			throw new UsernameNotFoundException(userName);
		}
		return new UserDetailsImpl(usuario);
	}

}
