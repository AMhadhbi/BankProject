package org.projects.banque.metier;

import java.util.Date;
import java.util.List;

import org.projects.banque.dao.IbanqueDao;
import org.projects.banque.entities.Client;
import org.projects.banque.entities.Compte;
import org.projects.banque.entities.Employe;
import org.projects.banque.entities.Groupe;
import org.projects.banque.entities.Operation;
import org.projects.banque.entities.Retrait;
import org.projects.banque.entities.Versement;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

	private IbanqueDao dao;

	public void setDao(IbanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		return dao.addClient(c);
	}

	@Override
	public Employe addEmploye(Employe e, Long codeSup) {
		// TODO Auto-generated method stub
		return dao.addEmploye(e, codeSup);
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		// TODO Auto-generated method stub
		return dao.addGroupe(g);
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGr) {
		// TODO Auto-generated method stub
		dao.addEmployeToGroupe(codeEmp, codeGr);
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long CodeEmp) {
		// TODO Auto-generated method stub
		return dao.addCompte(cp, codeCli, CodeEmp);
	}

	@Override
	public void verser(String codeCpte, double mt, Long codeEmp) {

		dao.addOperation(new Versement(new Date(), mt), codeCpte, codeEmp);
		Compte cp = dao.consulterCompte(codeCpte);
		cp.setSolde(cp.getSolde() + mt);
	}

	@Override
	public void retirer(String codeCpte, double mt, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(), mt), codeCpte, codeEmp);
		Compte cp = dao.consulterCompte(codeCpte);
		cp.setSolde(cp.getSolde() - mt);

	}

	@Override
	public void virement(String codeCpte1, String codeCpte2, double mt,
			Long codeEmp) {
		retirer(codeCpte1, mt, codeEmp);
		verser(codeCpte2, mt, codeEmp);

	}

	@Override
	public Compte consulterCompte(String codeCpte) {
		// TODO Auto-generated method stub
		return dao.consulterCompte(codeCpte);
	}

	@Override
	public List<Operation> consulterOperations(String codeCpte) {
		// TODO Auto-generated method stub
		return dao.consulterOperations(codeCpte);
	}

	@Override
	public Client consulterClient(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.consulterClient(codeCli);
	}

	@Override
	public List<Client> consulterClients(String mc) {
		// TODO Auto-generated method stub
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> getComptebyClients(Long codeCli) {
		// TODO Auto-generated method stub
		return dao.getComptebyClients(codeCli);
	}

	@Override
	public List<Client> getComptebyEmploye(Long codeEmp) {
		// TODO Auto-generated method stub
		return dao.getComptebyEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() {
		// TODO Auto-generated method stub
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		// TODO Auto-generated method stub
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGr) {
		// TODO Auto-generated method stub
		return dao.getEmployesByGroupe(codeGr);
	}

}
