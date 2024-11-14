package webhxh.model;

import java.io.Serializable;


public class BookAuthorModel_21146465 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int bookid;
	private int author_id;
	public BookAuthorModel_21146465() {
//		super();
	}
	public BookAuthorModel_21146465(int bookid, int author_id) {
		super();
		this.bookid = bookid;
		this.author_id = author_id;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	@Override
	public String toString() {
		return "BookAuthorModel_21146465 [bookid=" + bookid + ", author_id=" + author_id + "]";
	}
	
	
	
	


}
