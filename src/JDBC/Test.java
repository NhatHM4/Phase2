package JDBC;

import java.sql.Connection;
import java.sql.SQLException;

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
