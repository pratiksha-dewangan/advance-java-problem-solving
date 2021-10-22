package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;
	static {
		try {
			System.out.println("Creating session factory...");
			//create a populated session factory--
			//extends from configuration class -(not interface)
			//tf instance can be created
			factory = new Configuration().configure().buildSessionFactory();		
			System.out.println("Session factory created...");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getFactory() {
		return factory;
	}
	
	
}
