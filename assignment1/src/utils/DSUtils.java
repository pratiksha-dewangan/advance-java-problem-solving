package utils;
import java.sql.*;

public class DSUtils {
	
	//singleton instance of DB connection
	private static Connection cn;
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException{
		
		if(cn == null) {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
			cn = DriverManager.getConnection(url,"root","Monti@1996");
			
			
			System.out.println("Connected to DB: "+cn);
			
		}
		
		return cn;
	}
	

}
