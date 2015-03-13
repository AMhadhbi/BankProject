package org.projects.banque.model;

import org.projects.banque.entities.Compte;

public class BanqueForm {
	
	private String code;
	private Compte compte;
	private String typeCompte;
	
	
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	

}
