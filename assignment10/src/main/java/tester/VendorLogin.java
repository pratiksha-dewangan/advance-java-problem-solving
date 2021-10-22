package tester;

import java.util.Scanner;
import dao.VendorDaoImpl;
import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;
import pojos.Vendor;

public class VendorLogin {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			VendorDaoImpl vdao= new VendorDaoImpl();
			System.out.println("Enter vendor email: ");
			Vendor vendor = vdao.vendorLogin(sc.next());
			System.out.println(vendor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
