package tester;

import org.hibernate.SessionFactory;

import dao.VendorDaoImpl;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class DeleteVendors {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in) ){
			
			VendorDaoImpl vdao = new VendorDaoImpl();
			System.out.println("Enter vendor id: ");
			vdao.deleteVendor(sc.nextInt());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
