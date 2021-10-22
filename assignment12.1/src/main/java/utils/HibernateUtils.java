package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf;
	static {
		try {
			System.out.println("in static init block");
			// build singleton instance of SF (SessionFactory)
			sf = new Configuration().configure().buildSessionFactory();
			System.out.println("SF created....");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSf() {
		return sf;
	}
	
}
