package test;

import org.projects.banque.entities.Client;
import org.projects.banque.metier.IBanqueMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		 ClassPathXmlApplicationContext context =
				 
				 new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		 
		 IBanqueMetier metier= (IBanqueMetier) context.getBean("metier");
		
		 
		 metier.addClient(new Client("C1", "AD1"));
	}

}
