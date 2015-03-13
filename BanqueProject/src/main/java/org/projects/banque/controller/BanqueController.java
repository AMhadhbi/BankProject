package org.projects.banque.controller;

import org.projects.banque.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller  
public class BanqueController {
	
	@Autowired
	private IBanqueMetier metier;
	
	@RequestMapping(value="/index")
	public String index(){
		
		return "banque";
		
	}
	

}
