package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.projects.banque.entities.Client;
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
			assert (true);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}

	}

}
