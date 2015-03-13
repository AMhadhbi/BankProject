package org.projects.banque.metier;

import java.util.List;

import org.projects.banque.entities.Client;
import org.projects.banque.entities.Compte;
import org.projects.banque.entities.Employe;
import org.projects.banque.entities.Groupe;
import org.projects.banque.entities.Operation;

public interface IBanqueMetier {

	public Client addClient(Client c);

	public Employe addEmploye(Employe e, Long codeSup);

	public Groupe addGroupe(Groupe g);

	public void addEmployeToGroupe(Long codeEmp, Long codeGr);

	public Compte addCompte(Compte cp, Long codeCli, Long CodeEmp);

	public void verser(String codeCpte, double mt, Long codeEmp);

	public void retirer(String codeCpte, double mt, Long codeEmp);

	public void virement(String codeCpte1, String CodeCpte2, double mt,
			Long codeEmp);

	public Compte consulterCompte(String codeCpte);

	public List<Operation> consulterOperations(String codeCpte);

	public Client consulterClient(Long codeCli);

	public List<Client> consulterClients(String mc);

	public List<Compte> getComptebyClients(Long codeCli);

	public List<Client> getComptebyEmploye(Long codeEmp);

	public List<Employe> getEmployes();

	public List<Groupe> getGroupes();

	public List<Employe> getEmployesByGroupe(Long codeGr);

}
