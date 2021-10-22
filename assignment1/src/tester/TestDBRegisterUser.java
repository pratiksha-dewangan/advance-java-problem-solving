package tester;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import static utils.DSUtils.fetchConnection;

public class TestDBRegisterUser {

	public static void main(String[] args) {
		String sql = "insert into customers values(default,?,?,?,?,?,?)";
		try(Scanner sc = new Scanner(System.in);
				Connection cn = fetchConnection();
				PreparedStatement pst = cn.prepareStatement(sql))
						{
			
			System.out.println("Enter name,email,passwd,amt,reg date,role ");
	
			pst.setString(1, sc.next()); 
			pst.setString(2, sc.next());
			pst.setString(3, sc.next()); 
			pst.setDouble(4, sc.nextDouble());
			pst.setDate(5, Date.valueOf(sc.next())); 
			pst.setString(6, sc.next());
			
			
				int res= pst.executeUpdate();
				if(res ==0) {				
					System.out.println("Registration failed...!!S");
			}
				else
					System.out.println("Customer registered successfully...!!");
			
			
	//mona mon@gmail.com 1234 1260 2020-01-01 customer	
		}
		catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}








