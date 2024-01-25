package com.jsp.demo;


	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;
	@WebServlet("/updatedetails")
	public class update extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        HttpSession session2 = req.getSession();
			
		    String id1 = (String) session2.getAttribute("id");
			String id =req.getParameter("id");
			String name = req.getParameter("name");
			String yop = req.getParameter("yop");
			String age = req.getParameter("age");
			String mobilenumber = req.getParameter("mobilenumber");
			
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
				 PreparedStatement ps = con.prepareStatement("update student1 set id=?,name=?,yop=?,age=?,mobilenumber=? where id=?");
				 ps.setInt(1, Integer.parseInt(id));
				 ps.setString(2, name);
				 ps.setInt(3, Integer.parseInt(yop));
				 ps.setInt(4, Integer.parseInt(age));
				 ps.setLong(5, Integer.parseInt(mobilenumber));
				 ps.setInt(6, Integer.parseInt(id1));
				 
				 ps.execute();
				 
				 PrintWriter pw = resp.getWriter();
				 pw.println("Data Updated Successfully");
				 
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
			
			
		}

	}


