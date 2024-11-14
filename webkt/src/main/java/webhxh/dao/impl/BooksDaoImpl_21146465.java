package webhxh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webhxh.config.DBConnectMySQL_21146465;
import webhxh.dao.IBooksDao_21146465;

import webhxh.model.BooksModel_21146465;

public class BooksDaoImpl_21146465 extends DBConnectMySQL_21146465 implements IBooksDao_21146465 {

	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	
	@Override
	public List<BooksModel_21146465> findAll() {
		// TODO Auto-generated method stub
		
		String sql="Select * from books";
		List<BooksModel_21146465> list= new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				BooksModel_21146465 book= new BooksModel_21146465();
				
				
				book.setBookid((rs.getInt("bookid")));
				book.setIsbn((rs.getInt("isbn")));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getFloat("price"));
				book.setDescription(rs.getString("description"));
				book.setPublish_date(rs.getDate("publish_date"));
				book.setCover_image(rs.getString("cover_image"));
				book.setQuantity(rs.getInt("quantity"));
				list.add(book);
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
	public BooksModel_21146465 findByBookId(int id) {
		
		String sql="Select * from books where bookid=?";

		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs= ps.executeQuery();
			while(rs.next()) {
				BooksModel_21146465 book= new BooksModel_21146465();
				book.setBookid((rs.getInt("bookid")));
				book.setIsbn((rs.getInt("isbn")));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getFloat("price"));
				book.setDescription(rs.getString("description"));
				book.setPublish_date(rs.getDate("publish_date"));
				book.setCover_image(rs.getString("cover_image"));
				book.setQuantity(rs.getInt("quantity"));
				return book;
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

		BooksDaoImpl_21146465 authorDao = new BooksDaoImpl_21146465();
		BooksModel_21146465 author =authorDao.findByBookId(1);
		
		System.out.println(author);
		
//		List<AuthorModel_21146465> list =authorDao.findAllAuthor();
//
//		for (AuthorModel_21146465 user : list) {
//			System.out.println(user);
//		}

//		UserModel user1 = userDao.findById(1);
//	    if (user1 != null) {
//	        System.out.println(user1);
//	    } else {
//	        System.out.println("User not found!");
//	    }
	}
}
