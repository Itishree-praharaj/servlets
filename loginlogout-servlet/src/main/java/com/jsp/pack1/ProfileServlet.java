package com.jsp.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	HttpSession session = req.getSession(false);
	Object name = session.getAttribute("name");
	
	 
	if(name != null) {
	
		out.println(name + "welcome to profile page");
		
	} else {
		out.println("please login first");
		req.getRequestDispatcher("form.html").include(req, resp);
}
}
}

	