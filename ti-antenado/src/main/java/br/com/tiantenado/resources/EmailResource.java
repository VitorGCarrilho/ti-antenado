package br.com.tiantenado.resources;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiantenado.service.EmailService;
import br.com.tiantenado.model.Email;


@RestController
@RequestMapping("/api/rest/email")
public class EmailResource {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("send")
	public ResponseEntity<?> send(@RequestBody Email email){
		try {
			emailService.enviar(email);
			return ResponseEntity.status(HttpStatus.OK).body("Email enviado");
		} catch (EmailException e) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Ocorreu um erro ao enviar o email");
		}
		
	}

}
