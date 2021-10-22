package tester;

import dao.VendorDaoImpl;
import java.time.LocalDate;
import java.util.Scanner;
import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

public class DeleteVendorDetailsByAmtandDate {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {
			
			VendorDaoImpl vdao = new VendorDaoImpl();
			System.out.println("Enter reg amt n date to remove from db: ");
			vdao.deleteVendorDetails(sc.nextDouble(), LocalDate.parse(sc.next()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
