package br.com.tiantenado.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry){
		super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("Login/Login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}
