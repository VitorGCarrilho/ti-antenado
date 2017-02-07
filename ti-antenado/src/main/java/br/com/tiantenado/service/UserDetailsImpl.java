package br.com.tiantenado.service;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.tiantenado.model.TipoUsuario;
import br.com.tiantenado.model.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -592789463433838072L;
	
	private Usuario usuario;
	
	public UserDetailsImpl(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(usuario.getTipoUsuario().toString()));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return usuario.getDsSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getDsEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
