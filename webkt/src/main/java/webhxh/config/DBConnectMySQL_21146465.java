package webhxh.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL_21146465 {
	private static String USERNAME = "root";
	private static String PASSWORD = "hoxuanhuy";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/kt";

	public static Connection getDatabaseConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			new DBConnectMySQL_21146465();
			System.out.println(DBConnectMySQL_21146465.getDatabaseConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}