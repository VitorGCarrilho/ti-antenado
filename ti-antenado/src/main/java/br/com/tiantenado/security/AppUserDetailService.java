package br.com.tiantenado.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.repository.UsuarioRepository;

@Service
public class AppUserDetailService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByDsEmail(email);
		if (usuario == null){
			throw new UsernameNotFoundException(email);
		}
		Set<SimpleGrantedAuthority> authorities = new HashSet<>(); 
		authorities.add(new SimpleGrantedAuthority(usuario.getTipoUsuario().getDsTipoUsuario().toUpperCase()));
		
		return new User(usuario.getDsEmail(), usuario.getDsSenha(), authorities);
	}

}
