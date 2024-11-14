package webhxh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webhxh.config.DBConnectMySQL_21146465;
import webhxh.dao.IBookAuthorDao_21146465;
import webhxh.model.BookAuthorModel_21146465;

public class BookAuthorDaoImpl_2114645 extends DBConnectMySQL_21146465 implements IBookAuthorDao_21146465 {
	
	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	
	@Override
	public List<BookAuthorModel_21146465> findAll() {
		// TODO Auto-generated method stub
		
		String sql="Select * from book_author";
		List<BookAuthorModel_21146465> list= new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				BookAuthorModel_21146465 author= new BookAuthorModel_21146465();
				
				author.setAuthor_id((rs.getInt("author_id")));
				author.setBookid((rs.getInt("bookid")));
				
				list.add(author);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BookAuthorModel_21146465 findByAuthorId(int id) {
		
		String sql="Select * from book_author where author_id=?";

		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs= ps.executeQuery();
			while(rs.next()) {
				BookAuthorModel_21146465 author= new BookAuthorModel_21146465();
				author.setAuthor_id((rs.getInt("author_id")));
				author.setBookid((rs.getInt("bookid")));
				return author;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public List<BookAuthorModel_21146465> findlistauthorid(int keyword) {
		
		String sql="Select * from book_author where author_id like ?";
		List<BookAuthorModel_21146465> list= new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,keyword);
			rs= ps.executeQuery();
			while(rs.next()) {
				BookAuthorModel_21146465 author= new BookAuthorModel_21146465();
				author.setAuthor_id((rs.getInt("author_id")));
				author.setBookid((rs.getInt("bookid")));
				list.add(author);
				return list;
			}
			conn.close();
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;


		
	}
	
	
	
	
	
	public static void main(String[] args) {

		IBookAuthorDao_21146465 authorDao = new BookAuthorDaoImpl_2114645();
//		BookAuthorModel_21146465 author =authorDao.findByAuthorId(3);
//		
//		System.out.println(author);
		
		List<BookAuthorModel_21146465> list =authorDao.findlistauthorid(3);

		for (BookAuthorModel_21146465 user : list) {
			System.out.println(user);
		}

//		UserModel user1 = userDao.findById(1);
//	    if (user1 != null) {
//	        System.out.println(user1);
//	    } else {
//	        System.out.println("User not found!");
//	    }
	}

}
