package pages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voters;
import utils.DBUtils;

@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl votersDao;
	private CandidateDaoImpl candidatesDao;

	public void init() throws ServletException {
		System.out.println("in init of" + getClass().getName());
		try {
			votersDao = new VoterDaoImpl();
			candidatesDao = new CandidateDaoImpl();
		} 
		catch (Exception e) {
			throw new ServletException("error message " + getClass().getName(), e);
		}
	}

	public void destroy() {
		try {
			votersDao.cleanUp();
			candidatesDao.cleanUp();
			DBUtils.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("error message", e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			Voters voter = votersDao.authenticateVoter(email, password);
			if (voter == null) {
				pw.print("<h5>Invalid Login...!!! </h5>");
				pw.print("<h5> <a href='login.html'>Please Retry</a> </h5>");
			} 
			else {
				HttpSession session = request.getSession();
				session.setAttribute("voters_details", voter);
				session.setAttribute("voters_dao", votersDao);
				session.setAttribute("candidates_dao", candidatesDao);
				
				if (voter.getRole().equals("admin")) {
					response.sendRedirect("admin");
				} else {
					if (voter.getStatus() == false) {
						response.sendRedirect("list");
					} else {
						response.sendRedirect("status");
					}
				}
			}

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass().getName(), e);
		}
	}
}
