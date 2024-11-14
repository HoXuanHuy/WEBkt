package webhxh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import webhxh.config.DBConnectMySQL_21146465;
import webhxh.dao.IAuthorDao_21146465;
import webhxh.model.AuthorModel_21146465;



public class AuthorDaoImpl_21146465 extends DBConnectMySQL_21146465 implements IAuthorDao_21146465 {

	public Connection conn=null;
	public PreparedStatement ps=null;
	public ResultSet rs=null;
	
	@Override
	public List<AuthorModel_21146465> findAllAuthor() {
		// TODO Auto-generated method stub
		
		String sql="Select * from author";
		List<AuthorModel_21146465> list= new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			rs= ps.executeQuery();
			while(rs.next()) {
				AuthorModel_21146465 author= new AuthorModel_21146465();
				
				author.setAuthor_id((rs.getInt("author_id")));
				author.setAuthor_name((rs.getString("author_name")));
				author.setDate_of_birth(rs.getDate("date_of_birth"));
				
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
	public AuthorModel_21146465 findByAuthorId(int id) {
		
		String sql="Select * from author where author_id=?";

		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs= ps.executeQuery();
			while(rs.next()) {
				AuthorModel_21146465 author= new AuthorModel_21146465();
				author.setAuthor_id((rs.getInt("author_id")));
				author.setAuthor_name((rs.getString("author_name")));
				author.setDate_of_birth(rs.getDate("date_of_birth"));
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
	public void insert(AuthorModel_21146465 author) {
		String sql="INSERT INTO author(author_name, date_of_birth)\r\n"
				+ "VALUES (?,?)";

		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, author.getAuthor_name());
			ps.setDate(2,author.getDate_of_birth());
			ps.executeUpdate();
			
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(AuthorModel_21146465 author) {
		String sql="UPDATE author\r\n"
				+ "SET author_name = ?, date_of_birth = ?\r\n"
				+ "WHERE author_id=?";

		try {
			conn = super.getDatabaseConnection();
//			conn= new DBConnectMySQL().getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, author.getAuthor_name());
			ps.setDate(2,author.getDate_of_birth());
			ps.setInt(3, author.getAuthor_id());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void delete(int id) {


		String sql="DELETE FROM author WHERE author_id=?";

		try {
			conn = super.getDatabaseConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {

		IAuthorDao_21146465 authorDao = new AuthorDaoImpl_21146465();
		
		// Tạo đối tượng Date từ chuỗi ngày hợp lệ
//		Date dateOfBirth = Date.valueOf("2003-04-12"); // Sử dụng định dạng yyyy-MM-dd

		// Gọi phương thức insert với ngày sinh đã được chuyển đổi thành Date
//		authorDao.insert(new AuthorModel_21146465("xhuy", dateOfBirth));
//		authorDao.update(new AuthorModel_21146465(3,"x", dateOfBirth));
		authorDao.delete(3);
		
//		AuthorModel_21146465 author =authorDao.findByAuthorId(2);
//		
//		System.out.println(author);
		
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
