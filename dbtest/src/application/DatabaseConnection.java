package application;

import java.sql.*;

public class DatabaseConnection {

	public Connection databaseLink;
	
	public Connection getConnection() {
		String databaseName = "test1";
		String databaseUser = "root";
		String databasePassword = "1234";
		String url = "jdbc:mysql://localhost:1337/" + databaseName;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
			System.out.println("Connection Successful");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return databaseLink;
	}
	
}
