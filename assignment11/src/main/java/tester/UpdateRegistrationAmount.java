package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;
import dao.VendorDaoImpl;
import java.util.Scanner;
public class UpdateRegistrationAmount {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()){
			
			VendorDaoImpl vdao = new VendorDaoImpl();
			System.out.println("Enter email and new reg amt: ");
			vdao.UpdateRegistrationAmount(sc.next(), sc.nextDouble());

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
