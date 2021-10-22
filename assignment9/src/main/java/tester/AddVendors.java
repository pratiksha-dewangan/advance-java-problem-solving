package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDaoImpl;
import pojos.Vendor;

public class AddVendors {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			System.out.println("hibernate up & running" +sf);
			VendorDaoImpl vdao = new VendorDaoImpl();
			System.out.println("Enter Vendor info: ");
			System.out.println("name | email | password | regAmount | regDate(yyyy-MM-dd)");
			Vendor vendor = new Vendor(sc.next(),sc.next(),sc.next(),sc.nextDouble(),LocalDate.parse(sc.next()));
			System.out.println("status : "+vdao.addVendor(vendor));
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
