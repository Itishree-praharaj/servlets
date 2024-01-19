package servletdemo01;

import java.io.IOException;  
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/validate")
public class servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password =  req.getParameter("password");
		if(email.equals("jspider@gmail.com")&& password.equals("1234")) {
			RequestDispatcher rd= req.getRequestDispatcher("welcome1.html");
			rd.forward(req, res);
				
		}
		else {
			PrintWriter pout = res.getWriter();
			pout.println("<h1> invalid credentials </h1>");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			rd.include(req, res); 
		}
		
			
		
	}

}
