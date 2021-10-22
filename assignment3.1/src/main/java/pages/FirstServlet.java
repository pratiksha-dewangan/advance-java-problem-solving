package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */

//now wc start populating map
// key : /first urlPatterns | value : pages.FirstServelet
//@WebServlet(urlPatterns = {"/first","/abc","/xyz"}) all 3 are key 
//and values are same for all 3


@WebServlet(urlPatterns = "/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("in init :"+Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy :"+Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get :"+Thread.currentThread());
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			pw.print("Servelets are horrible....!! @"+LocalDateTime.now());
		}
	}

}

//in do-get :Thread[http-nio-8080-exec-10,5,main]
//name-priority-groupname
//1. set content type -- res.setContentType("text/html")
//2.Open PW --- try-- pw = response.getWriter()
//3.  print something
