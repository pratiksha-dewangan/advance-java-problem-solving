package tester;

import static utils.HibernateUtils.getFactory;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.VendorDaoImpl;
import pojos.Vendor;

public class GetVendorDetails {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
		
			VendorDaoImpl vdao = new VendorDaoImpl();
			System.out.println("Enter vendor id: ");
			Vendor vendor =  vdao.getVendorDetails(sc.nextInt());
			System.out.println(vendor);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
