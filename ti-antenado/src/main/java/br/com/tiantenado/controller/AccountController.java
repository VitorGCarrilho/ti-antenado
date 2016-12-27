package br.com.tiantenado.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.tiantenado.model.Account;
import br.com.tiantenado.model.Usuario;
import br.com.tiantenado.services.AccountService;
import br.com.tiantenado.services.UsuarioService;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private AccountService accountServices;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/")
	public String homeAccount(@RequestParam(name="page", defaultValue="1") Integer page, Model model){
		
		LocalDateTime now = LocalDateTime.now();
		
		Usuario usuario = new Usuario();
		usuario.setNmUsuario("Paulo");
		usuario.setDsEmail("paulo1911@gmail.com");
		
		usuarioService.saveOrUpdate(usuario);
		
		Account account = new Account();
		account.setCreationDate(now);
		account.setLastUpdate(now);
		account.setUsuario(usuario);
		
		accountServices.saveOrUpdate(account);
		
		Page<Account> accounts = accountServices.findAllPaginated(page, PAGE_SIZE, null);
		
		model.addAttribute("form", accounts);

		
		
		return "account/index";
	}
}

