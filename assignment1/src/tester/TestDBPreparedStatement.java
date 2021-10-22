package tester;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import static utils.DSUtils.fetchConnection;

public class TestDBPreparedStatement {

	public static void main(String[] args) {
		String sql = "select * from customers where email = ? and password = ?";
		try(Scanner sc = new Scanner(System.in);
				Connection cn = fetchConnection();
				PreparedStatement pst = cn.prepareStatement(sql))
						{
			
			System.out.println("Enter email and password:  ");
	
			pst.setString(1, sc.next()); 
			pst.setString(2, sc.next());
			
			try(ResultSet rst = pst.executeQuery()){
				if(rst.next()) {				
					System.out.printf("Empid %d Name %s registration amt %f Joined on %s role %s  %n",
							rst.getInt(1),rst.getString(2),rst.getDouble(5),rst.getDate(6),rst.getString(7));
			}
				else
					System.out.println("Invalid id, password");
				}
			
		
		}
		catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
}








