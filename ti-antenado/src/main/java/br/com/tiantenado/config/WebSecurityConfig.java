package br.com.tiantenado.config;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.tiantenado.model.TipoUsuario;
import br.com.tiantenado.security.AppUserDetailService;

@EnableWebSecurity
@ComponentScan(basePackageClasses = AppUserDetailService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
		
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers("/Layout/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http	
			.authorizeRequests()
					.antMatchers("/api/rest/**").hasAuthority(TipoUsuario.P.getDsTipoUsuario().toUpperCase())
					.antMatchers("/dashboard").hasAnyAuthority(TipoUsuario.P.getDsTipoUsuario().toUpperCase()
															, TipoUsuario.A.getDsTipoUsuario().toUpperCase()
															, TipoUsuario.R.getDsTipoUsuario().toUpperCase())
					.antMatchers(
										"/home"
										,"/teste"
										,"/cursos/**"
										,"/css/**"
										,"/fonts/**"
										,"/images/**"
										,"/js/**"
										, "/alunos/salvar"
										, "/alunos/cadastro"
										, "/professor/cadastro"
					).permitAll()
					.anyRequest().authenticated()
					.and()
			.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
			.logout()
					.logoutSuccessUrl("/login?logout")
					.permitAll()
					.and()
			.httpBasic();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
