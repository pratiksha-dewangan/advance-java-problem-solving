package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDaoImpl;
import pojos.Vendor;

public class FindVendorsById {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			System.out.println("hibernate up & running" +sf);
			VendorDaoImpl vdao = new VendorDaoImpl();
			System.out.println("Enter vendor Id : ");
			Vendor vendor =  vdao.findVendorDetailsById(sc.nextInt());
			System.out.println(vendor);
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}

}
