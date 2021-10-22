package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voters;
import utils.DBUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServ
 */

@WebServlet(urlPatterns= "/authenticate" , loadOnStartup = 1)
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl voterdao;
	private CandidateDaoImpl candidatedao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			System.out.println("In init : LoginServlet "+getClass().getName());	
			voterdao = new VoterDaoImpl();
			candidatedao = new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error is init "+getClass().getName(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			System.out.println("In destroy : Login Servlet" +getClass().getName());
			voterdao.cleanUp();
			candidatedao.cleanUp();
			DBUtils.closeConnection();
			
		} catch (Exception e) {
			throw new RuntimeException("error in destroy "+ getClass().getName());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			
			Voters v = voterdao.authenticateVoter(email, password);
			if(v==null)
			{
				pw.write("<h3>Invalid Login Credentials...!!</h3>");
				pw.write("<h3><a href= 'login.html' >Please Retry</a></h3>");
			}
			else {
				request.setAttribute("voters_dao", v);
				RequestDispatcher rd;
				if(v.getRole().equals("admin")) {
					rd = request.getRequestDispatcher("admin");
				}
				else {
					if(v.getStatus()==true) 
						rd = request.getRequestDispatcher("status");
					else 
						 rd = request.getRequestDispatcher("list");
				}
				rd.forward(request, response);
			}
			
			
		} catch (Exception e) {
			throw new ServletException("in do post : "+getClass().getName(),e);
		}
			}
		
		}
