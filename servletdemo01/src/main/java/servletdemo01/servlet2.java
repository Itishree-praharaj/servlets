package servletdemo01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/tom")
public class servlet2  extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id=req.getParameter("id");
	String name=req.getParameter("name");
	String age=req.getParameter("age");
	
	System.out.println(Integer.parseInt(id));
	System.out.println(name);
	System.out.println(Integer.parseInt(age));
	
}
}
