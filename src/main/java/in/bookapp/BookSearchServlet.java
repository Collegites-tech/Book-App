package in.bookapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookSearchServlet extends HttpServlet {
	
	private Connection conn;
	private PreparedStatement ps;
	
	@Override
	public void init() throws ServletException {
		try {
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase","root","Kiyansh@15");
			ps=conn.prepareStatement("select * from allbooks where subject=?");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			ServletException e=new ServletException(ex.getMessage());
			throw e;
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subject=req.getParameter("subject");
		
		try {
			ps.setString(1, subject);
			ResultSet rs= ps.executeQuery();
			
			List<Book> bookList= new ArrayList<>();
			while(rs.next()) {
				Book b= new Book();
				
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));		
				b.setBookprice(rs.getDouble(3));
				b.setSubject(rs.getString(4));	
				bookList.add(b);
			}
			
			req.setAttribute("subject", subject);
			req.setAttribute("booklist", bookList);
			
			RequestDispatcher rd=req.getRequestDispatcher("DisplayBookServlet");
			rd.forward(req, resp);
		}catch(SQLException ex) {
			System.out.println("Exception is : "+ex);
		}
	}
	
	@Override
	public void destroy() {
		try {
			conn.close();
		}catch(SQLException ex) {
			System.out.println("Exception in destroy: "+ex);
		}
	}

}
