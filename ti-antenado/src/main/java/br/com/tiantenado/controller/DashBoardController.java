package br.com.tiantenado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dashboard")
public class DashBoardController {
	@RequestMapping("")
	public String dashBoard(){
		return "dashboard/dashboard";
	}
}
