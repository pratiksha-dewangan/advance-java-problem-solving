package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voters;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			Voters v = (Voters) session.getAttribute("voters_details");
			if (v != null) {
				
				VoterDaoImpl votersDao = (VoterDaoImpl) session.getAttribute("voters_dao");
				CandidateDaoImpl candidatesDao = (CandidateDaoImpl) session.getAttribute("candidates_dao");

				pw.print("<h1>Login Successfully</h1>");
				pw.print("<br>");
				pw.print("Hello " + v.getName());
				pw.print("<br>");
				if (v.getStatus()) {
					pw.print("Already casted vote");
				} 
				else {
					int cand = Integer.parseInt(request.getParameter("candidate"));
					votersDao.voteCasted(v.getId());
					candidatesDao.castVotes(cand);
					pw.print("<h2>Successfully casted vote</h2>");
				}
			} else {
				pw.print("session tracking failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
