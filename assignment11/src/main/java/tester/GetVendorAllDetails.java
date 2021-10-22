package tester;

import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;
import org.hibernate.SessionFactory;
import dao.VendorDaoImpl;
import pojos.Vendor;

public class GetVendorAllDetails {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
		
			VendorDaoImpl vdao = new VendorDaoImpl();
			System.out.println("List of all vendors....");
			vdao.getAllVendorDetails().stream().forEach(System.out::println);
			
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
