package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.projects.banque.entities.Client;
import org.projects.banque.entities.CompteCourant;
import org.projects.banque.entities.CompteEpargne;
import org.projects.banque.entities.Employe;
import org.projects.banque.entities.Groupe;
import org.projects.banque.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJ1 {

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");

			metier.addClient(new Client("C1", "AD1"));
			metier.addClient(new Client("C2", "AD2"));

			metier.addEmploye(new Employe("E1"), null);
			metier.addEmploye(new Employe("E2"), 1L);
			metier.addEmploye(new Employe("E3"), 1L);

			metier.addGroupe(new Groupe("G1"));
			metier.addGroupe(new Groupe("G2"));

			metier.addEmployeToGroupe(1L, 1L);
			metier.addEmployeToGroupe(2L, 2L);
			metier.addEmployeToGroupe(3L, 2L);

			metier.addCompte(new CompteCourant("CC1", new Date(), 9000, 4000),
					1L, 2L);
			metier.addCompte(new CompteEpargne("CE1", new Date(), 5900, 5.5),
					2L, 2L);

			metier.verser("CC1", 5000, 2L);
			metier.retirer("CC1", 1000, 2L);
			metier.virement("CC1", "CE1", 4000, 1L);

			assert (true);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}

	}

}
