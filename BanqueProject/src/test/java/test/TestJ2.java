package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.projects.banque.entities.Compte;
import org.projects.banque.entities.Operation;
import org.projects.banque.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJ2 {

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
			Compte cp = metier.consulterCompte("CC1");

			System.out.println("Solde : " + cp.getSolde());
			System.out.println("Date : " + cp.getDateCreation());
			System.out.println("Empoyé : " + cp.getEmploye().getNomEmploye());
			System.out.println("Client : " + cp.getClient().getNomClient());

			List<Operation> ops = metier.consulterOperations("CC1");

			for (Operation op : ops) {
				System.out.println("************");
				System.out.println(op.getNumOperation());
				System.out.println(op.getDateOperation());
				System.out.println(op.getMontant());
				System.out.println(op.getClass().getSimpleName());

			}

			assert (true);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
}
