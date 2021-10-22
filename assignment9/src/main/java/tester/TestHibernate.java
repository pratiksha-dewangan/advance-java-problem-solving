package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDaoImpl;
import pojos.Vendor;

public class TestHibernate {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			Vendor vendor;
			VendorDaoImpl vdao = new VendorDaoImpl();
			System.out.println("hibernate up & running" +sf);
			System.out.println("Option 1. Add vendors 2. Find vendors by id");
			
			try {
				switch (sc.nextInt()) {
				case 1: //Add Vendors
					System.out.println("Enter Vendor info: ");
					System.out.println("name | email | password | regAmount | regDate(yyyy-MM-dd)");
					vendor = new Vendor(sc.next(),sc.next(),sc.next(),sc.nextDouble(),LocalDate.parse(sc.next()));
					System.out.println("status : "+vdao.addVendor(vendor));
					break;

				case 2: //Find vendors by id
					System.out.println("Enter vendor Id : ");
					vendor =  vdao.findVendorDetailsById(sc.nextInt());
					System.out.println(vendor);
					break;
					
				case 3: //Get all vendor details
					
					
				default:
					System.out.println("Invalid Choice...!!");
					break;
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}

}
