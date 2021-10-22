package dao;

import java.sql.SQLException;
import pojos.Voter;

public interface IVoterDao {
	
	Voter voterLogin(String email , String password) throws SQLException;
	String incrVote(int id) throws ClassNotFoundException, SQLException;
}
