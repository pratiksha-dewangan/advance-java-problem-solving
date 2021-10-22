package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;
	
	//establishing connection
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException{
		if(cn == null)
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
			cn = DriverManager.getConnection(url, "root","Monti@1996" );
		return cn;
	}
	
	//close the connection
	public static void closeConnection() throws SQLException {
		if(cn != null)
			cn.close();
	}
}









//for estbalish connec---  class.forname/url/DM.getconnection
//for closing conn - check if null