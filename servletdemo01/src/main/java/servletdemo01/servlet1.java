package servletdemo01;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/httpreq")
public class servlet1  extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		//	String email = req.getParameter("email");
		//	String password = req.getParameter("password");
			
	//	System.out.println(email);
	//	System.out.println(password);
		RequestDispatcher rd = req.getRequestDispatcher("/tom");
		rd.forward(req, resp);
		
			
	}

}
