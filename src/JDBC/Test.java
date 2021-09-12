package JDBC;

import java.sql.Connection;
import java.sql.SQLException;

import General_Assignment.Services.JDBC;

public class Test {
	public static void main(String[] args) {
		try {
			Connection cnn = JDBC.getConnections();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
