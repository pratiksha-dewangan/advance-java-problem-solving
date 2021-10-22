package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloUser
 */
@WebServlet("/test_input")
public class HelloUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw  = response.getWriter()){
			pw.write("<h5>Hello ,"+request.getParameter("f1")+"</h5>");//Hello , user name
			pw.write("<h5>Favourite Colors :"+Arrays.toString(request.getParameterValues("clr"))+"</h5>");//Favorite Colors : ...
			pw.write("<h5>Chosen Browser :"+request.getParameter("browser")+"</h5>");//Chosen Browser : ..
			pw.write("<h5>Selected city :"+request.getParameter("myselect")+"</h5>");//Selected City : 
			pw.write("<h5>About Yourself :"+request.getParameter("info")+"</h5>");//About Yourself : `
		}
	}

}
