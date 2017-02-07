package br.com.tiantenado.service;

import br.com.tiantenado.model.Usuario;

public interface UserService {
	public Usuario findByDsEmail(String email);
}
