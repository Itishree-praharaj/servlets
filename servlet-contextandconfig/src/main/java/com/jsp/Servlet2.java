package com.jsp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet2  extends GenericServlet{ 
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		ServletContext context = getServletContext();
		System.out.println(context.getInitParameter("url"));
		System.out.println(context.getServerInfo());
		System.out.println(context.getServerInfo());
		
	}

}

