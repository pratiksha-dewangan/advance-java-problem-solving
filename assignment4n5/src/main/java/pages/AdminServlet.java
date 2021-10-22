package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.CandidateDaoImpl;
import pojos.Candidate;
import pojos.Voters;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			Voters v = (Voters) session.getAttribute("voters_details");
			if (v != null) {
				pw.print("<h1>Hello, " + v.getName()+ "</h1>");
				pw.print("<br>");
				pw.print("<h1>List of all Candidates are : </h1>");
				pw.print("<br>");
				pw.print("<br>");
				pw.print("<br>");
				
				CandidateDaoImpl candidatesDao = (CandidateDaoImpl) session.getAttribute("candidates_dao");
				List<Candidate> candidates = candidatesDao.fetchDetailsOfCandidate();
				pw.print("<table border = '1'>");
				for (Candidate c : candidates) {	
					
					pw.print("<tr>");
						pw.print("<td>");
						pw.print(c.getId());
						pw.print("</td>");
						
						pw.print("<td>");
						pw.print(c.getName());
						pw.print("</td>");
						
						pw.print("<td>");
						pw.print(c.getParty());
						pw.print("</td>");
						
						pw.print("<td>");
						pw.print(c.getVotes());
						pw.print("</td>");
						
					pw.print("</tr>");
			
				}
				pw.print("</table>");

			} else {
				pw.print("Session tracking failed....!!!!");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
