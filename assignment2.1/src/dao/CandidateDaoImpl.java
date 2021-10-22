package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchConnection;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao{

	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;

	public CandidateDaoImpl() throws SQLException, ClassNotFoundException {
		super();
		cn = fetchConnection();
		pst1 = cn.prepareStatement("insert into candidates values(default,?,?,?)");
		pst2 = cn.prepareStatement("select * from candidates");
		pst3= cn.prepareStatement("update candidates set votes = votes+1 where id = ?");
		
	}

	@Override
	public List<Candidate> displayCandidates(String name, String party, int votes) throws SQLException {
		List<Candidate> caninfo = new ArrayList<>();
		
		pst1.setString(1, name);
		pst1.setString(2, party);
		pst1.setInt(3, votes);
	
		
		int canCount = pst1.executeUpdate();
		
		if(canCount != 0) 
			caninfo.add(new Candidate(name,party,0));
		return caninfo;
		
}
			
	@Override
	public List<Candidate> displayAllCandidates() throws SQLException {
		List<Candidate> caninfo = new ArrayList<>();
		try(ResultSet rst = pst2.executeQuery()){
			while(rst.next()) {
				caninfo.add(new Candidate(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4)));
			}
		}
		return caninfo;
	}
	
	@Override
	public String changeVotingStatus(int id) throws SQLException, ClassNotFoundException {
		String mesg= "Sorry cannot increment..!!";
		pst3.setInt(1, id);
		
		int count = pst3.executeUpdate();
		if(count!= 0)
			mesg = "Update vote by 1";
		return mesg;
	}
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if(pst2!= null)
			pst2.close();
		System.out.println("voter dao cleaned.....");
	}

	

	

}
