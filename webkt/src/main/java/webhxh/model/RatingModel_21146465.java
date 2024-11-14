package webhxh.model;

import java.io.Serializable;


public class RatingModel_21146465 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userid;
	private int bookid;
	private byte rating;
	private String review_text;
	public RatingModel_21146465() {
//		super();
	}
	public RatingModel_21146465(int userid, int bookid, byte rating, String review_text) {
		super();
		this.userid = userid;
		this.bookid = bookid;
		this.rating = rating;
		this.review_text = review_text;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public byte getRating() {
		return rating;
	}
	public void setRating(byte rating) {
		this.rating = rating;
	}
	public String getReview_text() {
		return review_text;
	}
	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}
	@Override
	public String toString() {
		return "RatingModel_21146465 [userid=" + userid + ", bookid=" + bookid + ", rating=" + rating + ", review_text="
				+ review_text + "]";
	}
	
	
	
	
	
	
	
	

}
