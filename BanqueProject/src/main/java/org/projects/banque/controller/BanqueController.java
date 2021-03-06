package org.projects.banque.controller;

import java.util.List;

import javax.validation.Valid;

import org.projects.banque.entities.Compte;
import org.projects.banque.entities.Operation;
import org.projects.banque.metier.IBanqueMetier;
import org.projects.banque.model.BanqueForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String charger(@Valid BanqueForm bf, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "banque";
		}
		chargerCompte(bf);
		model.addAttribute("banqueForm", bf);
		return "banque";

	}

	@RequestMapping(value = "/saveOperation")
	public String Save(@Valid BanqueForm bf, BindingResult bindingResult) {

		
			if (bindingResult.hasErrors()) {
				return "banque";
			}
			try {
			if (bf.getAction() != null) {
				if (bf.getTypeOperation().equals("VER")) {
					metier.verser(bf.getCode(), bf.getMontant(), 1L);
				}

				else if (bf.getTypeOperation().equals("RE")) {

					metier.retirer(bf.getCode(), bf.getMontant(), 1L);
				} else if (bf.getTypeOperation().equals("VIR")) {

					metier.virement(bf.getCode(), bf.getCode2(),
							bf.getMontant(), 1L);
				}
			}

		} catch (Exception e) {
			bf.setException(e.getMessage());
		}
		chargerCompte(bf);
		return "banque";

	}

	public void chargerCompte(BanqueForm bf) {
		try {
			Compte cp = metier.consulterCompte(bf.getCode());
			bf.setTypeCompte(cp.getClass().getSimpleName());
			bf.setCompte(cp);
          int pos=bf.getNbLignes()*bf.getNbPages();
			List<Operation> ops = metier
					.consulterOperations(bf.getCode(), pos,bf.getNbLignes());
			bf.setOperations(ops);
			long nbOp=metier.getNombreOperation(bf.getCode());
			bf.setNbPages((int)(nbOp/bf.getNbLignes())+1);
		} catch (Exception e) {
			bf.setException(e.getMessage());
		}
	}
}
