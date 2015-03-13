package org.projects.banque.controller;

import org.projects.banque.entities.Compte;
import org.projects.banque.metier.IBanqueMetier;
import org.projects.banque.model.BanqueForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BanqueController {

	@Autowired
	private IBanqueMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("banqueForm", new BanqueForm());
		return "banque";

	}
	
	
	@RequestMapping(value = "/chargerCompte")
	public String charger(@Validated BanqueForm bf,BindingResult bindingResult ,Model model) {
		if(bindingResult.hasErrors()){
			return "banque";
		}
		try{
			Compte cp=metier.consulterCompte(bf.getCode());
			bf.setTypeCompte(cp.getClass().getSimpleName());
			bf.setCompte(cp);
		}
		
		catch (Exception e){
			bf.setException(e.getMessage());
		}
		
		
		model.addAttribute("banqueForm", bf);
		return "banque";

	}

}
