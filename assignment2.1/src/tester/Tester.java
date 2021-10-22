package tester;

import java.util.List;
import java.util.Scanner;
import dao.CandidateDaoImpl;
import dao.VoterDaoImp;
import pojos.Candidate;
import pojos.Voter;
import static utils.DBUtils.closeConnection;

public class Tester {

	public static void main(String[] args) {

		try(Scanner sc = new Scanner(System.in)){
			boolean exit = false;
			VoterDaoImp vdao = new VoterDaoImp();
			CandidateDaoImpl cdao = new CandidateDaoImpl();
			
			while(!exit) {
				System.out.println("Option 1. Voter Login 2. Candidate Registartion");
				System.out.println("3. List all candidates 4. Cast a Vote 5. Exit");
				
				try {
					
					switch (sc.nextInt()) {
					case 1://1. Voter login -- i/p : email & password ---o/p status mesg
						System.out.println("Enter voter's email and password: ");
						Voter voter = vdao.voterLogin(sc.next(),sc.next());
						if(voter == null)
							System.out.println("Invalid login");
						else
							System.out.println("Login successful..!!");
						break;
						
					case 2: //2. Candidate registration ---i/p candidate details excluding id & votes -->o/p : status message*/
						System.out.println("Enter name and party name : ");
						List<Candidate> candidate = cdao.displayCandidates(sc.next(), sc.next(),0);
						if(candidate != null)
							System.out.println(candidate);
						else
							System.out.println("No candidate registered yet..!!");
						break;
						
					case 3:// 3. List all candidates
						System.out.println("List of all candidates are: ");
						List<Candidate> allCandidate = cdao.displayAllCandidates();
						if(allCandidate != null)
							allCandidate.forEach(System.out::println);
						else
							System.out.println("No candidate present..!!");
						break;
						
					case 4: //4. Cast a Vote--> i/p : candidate id & voter id--> o/p status mesg
						/* Action : inc candidate's votes & change voting status to true.*/
						System.out.println("Enter your voter id to cast vote: ");
						String v1 = vdao.incrVote(sc.nextInt());
						System.out.println(v1);		
						System.out.println("Enter Candidate id to update num of votes: ");
						String c1 = cdao.changeVotingStatus(sc.nextInt());		
						System.out.println(c1);
						
						
						break;
						
					case 5:
						exit = true;
						vdao.cleanUp();
						cdao.cleanUp();
						closeConnection();
						break;
						
					default:
						System.out.println("Invalid Choice...!!!");
						break;
					}
					
					
					
				}
				catch (Exception e) {
					e.printStackTrace();
					System.out.println("Tester's inner");
				}
				
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Tester's outer");
		}

	}

}
