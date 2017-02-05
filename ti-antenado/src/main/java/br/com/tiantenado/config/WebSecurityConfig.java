package br.com.tiantenado.config;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("vitor").password("senha").roles("USER","ADMIN")
		.and().withUser("jose").password("senha").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	
			.authorizeRequests()
				.antMatchers("/home","/cursos/**","/usuarios/cadastro","/css/**","/fonts/**","/images/**","/js/**").permitAll()
				.antMatchers("/api/rest/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
			.logout()
					.logoutSuccessUrl("/login?logout")
					.permitAll();
	}
}
