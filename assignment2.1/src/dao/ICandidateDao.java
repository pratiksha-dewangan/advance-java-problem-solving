package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;
public interface ICandidateDao {

	List<Candidate> displayCandidates(String name, String party, int votes) throws SQLException;
	List<Candidate> displayAllCandidates() throws SQLException;
	String changeVotingStatus(int id) throws SQLException,ClassNotFoundException;	
}
