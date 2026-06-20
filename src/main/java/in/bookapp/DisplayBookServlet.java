package in.bookapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayBookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subject= (String) req.getAttribute("subject");
		List<Book> booklist = (List<Book>) req.getAttribute("booklist");
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		if(booklist.isEmpty())
			pw.println("<h2>Sorry We do not have any books of the subject "+subject+"!!<h2>");
		else {
			pw.println("<h2>Following are the books of Subject "+subject+"</h2> <br><table border='2'>");
			pw.println("<tr><th>Book ID</th><th>Book Name</th><th>Book Price</th><th>Subject</th></tr>");
			
			for(Book b:booklist) {
				pw.println("<tr><td>"+b.getBookid()+"</td><td>"+b.getBookname()+"</td><td>"+b.getBookprice()+"</td><td>"+subject+"</td></tr>");
			}
			pw.println("</table>");
		}
		
	}

}
