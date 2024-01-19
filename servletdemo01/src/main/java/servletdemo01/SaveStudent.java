package servletdemo01;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/savestudent")
public class SaveStudent  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id =req.getParameter("id"); // id
		String name =req.getParameter("name"); //name
	    String age =req.getParameter("age"); //age
		
		
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
				PreparedStatement ps = con.prepareStatement("insert into student(id,name,age) values(?,?,?)");
				ps.setInt(1, Integer.parseInt(id));
				ps.setString(2, name);
				ps.setInt(3, Integer.parseInt(age));
				
				ps.execute();
				
				PrintWriter pw= res.getWriter();
				pw.print("<h1> welcome + name+ </h1>");
					pw.print("<h1>Data saved successfully</h1>");
					pw.print("<a href='studentform.html'> click here to save again</a>");
				
			} catch ( ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
}


