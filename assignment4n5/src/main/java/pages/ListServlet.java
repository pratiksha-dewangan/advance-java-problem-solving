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

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try (PrintWriter pw = response.getWriter()) {
			
			pw.print("<h1>Successful Login...!!!</h1>");
			HttpSession hs = request.getSession();
			System.out.println("from 2nd page HS is new " + hs.isNew());// false
			Voters v = (Voters) hs.getAttribute("voters_details");

			if (v != null)
				pw.print("<h1> Hello ," + v.getName() + "</h1>");
			else
				pw.print("<h5> session failed</h5>");

			CandidateDaoImpl candidatesDao = (CandidateDaoImpl) hs.getAttribute("candidates_dao");
			List<Candidate> candidates = candidatesDao.fetchDetailsOfCandidate();
			pw.print("<h3>");
			pw.print("<form action='status'>");
			for (Candidate c : candidates) {
				
				pw.print("<input type='radio'  name='candidate' value='" + c.getId() + "'>");
				pw.print(c);
				pw.print("<br>");
			
			}
			pw.print("<br><input type='submit' value='vote'>");
			pw.print("</form>");
			pw.print("</h3>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
