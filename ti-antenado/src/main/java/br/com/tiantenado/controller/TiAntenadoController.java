package br.com.tiantenado.controller;

import java.sql.Connection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tiantenado.config.DataBaseConfig;

@Controller
public class TiAntenadoController {

	@RequestMapping("/home")
	public String home(){
			
		return "index";
	}
	
}
