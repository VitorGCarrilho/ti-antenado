package br.com.tiantenado.service;



import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void enviar (br.com.tiantenado.model.Email email) throws EmailException {		
		Email mail = new SimpleEmail();
		mail.setHostName("smtp.googlemail.com");
		mail.setSmtpPort(465);
		mail.setAuthenticator(new DefaultAuthenticator("projetotiantenado", "unisal2017"));
		mail.setSSLOnConnect(true);
		
		mail.setFrom("projetotiantenado@gmail.com", "Ti Antenado");
		mail.setSubject(email.getTitulo());
		mail.setMsg(email.getCorpo());
		mail.addTo(email.getPara());
		mail.send();
			
	}

}
