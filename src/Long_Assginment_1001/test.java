package Long_Assginment_1001;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.JDBC;

public class test {
	public static void main(String[] args) {
		Connection cnn = null;
		CallableStatement cab = null;
		
		try {
			cnn = JDBC.getConnections();
			String sql = "{Call deletecustomer(?,?)}";
			cab = cnn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cab.setString(1, "C001");
			cab.registerOutParameter(2, java.sql.Types.INTEGER);
			cab.executeUpdate();
			int count = cab.getInt(2);
			System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
