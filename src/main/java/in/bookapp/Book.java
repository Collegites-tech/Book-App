package in.bookapp;

public class Book {
	
	private int bookid;
	private String bookname;
	private String subject;
	private double bookprice;
	
	public Book(int bookid, String bookname, String subject, double bookprice) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.subject = subject;
		this.bookprice = bookprice;
	}

	public Book() {

	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getBookprice() {
		return bookprice;
	}

	public void setBookprice(double d) {
		this.bookprice = d;
	}
	
}
