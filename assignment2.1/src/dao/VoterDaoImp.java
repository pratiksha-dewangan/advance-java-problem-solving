package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojos.Voter;

import static utils.DBUtils.fetchConnection;

public class VoterDaoImp implements IVoterDao {
private Connection cn;
private PreparedStatement pst1,pst2;

public VoterDaoImp() throws ClassNotFoundException, SQLException  {
	super();
	cn = fetchConnection();
	pst1 = cn.prepareStatement("select * from voters where email = ? and password = ?");
	pst2 = cn.prepareStatement("update voters set status = ? where id = ?");
}

@Override
public Voter voterLogin( String email, String password) throws SQLException {
	pst1.setString(1, email);
	pst1.setString(2, password);
	
	try(ResultSet rst = pst1.executeQuery()) {
		
		if(rst.next())
			// id (a-i)\name \email \password \status \role
			return (new Voter(rst.getInt(1) ,rst.getString(2), email, password, rst.getBoolean(5), rst.getString(6)));			
	}
	return null;
}

@Override
public String incrVote(int id) throws SQLException {
	String mesg = "Invalid id..!! You cannot cast vote..";
	pst2.setBoolean(1, true);
	pst2.setInt(2, id);
	int incCount = pst2.executeUpdate();
	if(incCount != 0)
		mesg = "Vote Casted";
	return mesg;
}
	
public void cleanUp() throws SQLException {
	if (pst1 != null)
		pst1.close();	
	System.out.println("voter dao cleaned.....");
}


}
