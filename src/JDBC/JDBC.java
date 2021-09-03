package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	public static Connection getConnections() throws SQLException {
		final String JDBC = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		final String User = "nhat1";
		final String Password = "1234";
		Connection connection = null;
		
		
		try {
			Class.forName(JDBC);
			String ConnectionURL = "jdbc:sqlserver://DESKTOP-D01NKHU:1433;databaseName=Long_Assignment_1001;integratedSecurity=false";
			connection = DriverManager.getConnection(ConnectionURL, User, Password);
			System.out.println("Ket noi thanh cong");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		return connection;
	}
}
