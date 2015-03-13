package org.projects.banque.model;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.projects.banque.entities.Compte;

public class BanqueForm {
	@NotEmpty
	@Size(min=2, max=10)
	private String code;
	private Compte compte;
	private String typeCompte;
	private String exception;
	
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
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
