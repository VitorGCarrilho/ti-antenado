package br.com.tiantenado.controller;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tiantenado.config.DataBaseConfig;
import br.com.tiantenado.dao.CursosDao;
import br.com.tiantenado.model.Curso;

@Controller
public class TiAntenadoController {

	@RequestMapping("/home")
	public String home(){
		
		return "index";
	}
	
}
