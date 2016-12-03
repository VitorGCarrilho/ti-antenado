package br.com.tiantenado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TiAntenadoController {

	@RequestMapping("/home")
	public String home(){
		return "index";
	}
	
}
