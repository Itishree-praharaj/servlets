package servletdemo01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fetchdata")
public class FetchDataFromFE extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String a = req.getParameter("monday"); //return null coz we passed invalid key
	
		PrintWriter pout =res.getWriter();
		pout.print("<h1> welcome" + name + "</h1>");
		}
	}


