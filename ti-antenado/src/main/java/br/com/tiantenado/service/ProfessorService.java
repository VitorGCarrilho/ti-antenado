package br.com.tiantenado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tiantenado.exception.EmailJaCadastradoException;
import br.com.tiantenado.exception.SenhaInvalidaException;
import br.com.tiantenado.model.TipoUsuario;
import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.repository.UsuarioRepository;

@Service
public class ProfessorService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passWordEncoder;
	
	
	public boolean cadastrarProfessor(Usuario usuario,  BindingResult result, 
			RedirectAttributes attributes) throws EmailJaCadastradoException, SenhaInvalidaException{
		
		Usuario user = usuarioRepository.findByDsEmail(usuario.getDsEmail());
		if (user != null) {
			throw new EmailJaCadastradoException();
		}
		if (usuario.isValidPassword()){
			usuario.setDsSenha(this.passWordEncoder.encode(usuario.getDsSenha()));
			usuario.setTipoUsuario(TipoUsuario.P);		
			usuarioRepository.save(usuario);
			return true;
		} 
		
		throw new SenhaInvalidaException();
	}
}
