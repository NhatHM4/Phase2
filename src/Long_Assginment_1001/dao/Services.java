package Long_Assginment_1001.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import JDBC.JDBC;
import Long_Assginment_1001.entities.Customer;
import Long_Assginment_1001.entities.LineItem;
import Long_Assginment_1001.entities.Order;
import Long_Assginment_902.Validator;

public class Services {
	public static List<Customer> getAllCustomer() {
		List<Customer> listCus = new ArrayList<Customer>();
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			cnn = JDBC.getConnections();
			String sql = "select * from customer";
			statement = cnn.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				Customer cs = new Customer();
				cs.setCustomerId(rs.getInt("customer_id"));
				cs.setCustomerName(rs.getString("customer_name"));
				listCus.add(cs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCus;
	}

	public static List<Order> getAllOrdersByCustomerId(int customerId) {
		List<Order> listOrder = new ArrayList<Order>();
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			cnn = JDBC.getConnections();
			String sql = "select * from orders";
			statement = cnn.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setCustomerId(rs.getInt("order_id"));
				order.setOrderDate(Validator.validLocalDate(rs.getString("order_date")));
				order.setCustomerId(rs.getInt("customer_id"));
				order.setEmployeeId(rs.getInt("employee_id"));
				order.setTotal(rs.getDouble("total"));
				listOrder.add(order);
			}
			for (Order order : listOrder) {
				if (order.getCustomerId() == customerId) {
					System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", order.getCustomerId(),
							order.getOrderDate().toString(), order.getCustomerId(), order.getEmployeeId(),
							order.getTotal());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOrder;

	}

	public static List<LineItem> getAllItemsByOrderId(int orderId) {
		List<LineItem> listLine = new ArrayList<LineItem>();
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			cnn = JDBC.getConnections();
			String sql = "select * from lineitem";
			statement = cnn.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				LineItem lt = new LineItem();
				lt.setOrderId(rs.getInt("order_id"));
				lt.setProductId(rs.getInt("product_id"));
				lt.setQuantity(rs.getInt("quantity"));
				lt.setPrice(rs.getDouble("price"));
				listLine.add(lt);
			}
			for (LineItem lineItem : listLine) {
				if (lineItem.getOrderId() == orderId) {
					System.out.printf("| %-20s | %-20s | %-20s | %-20s |%n", lineItem.getOrderId(),
							lineItem.getProductId(), lineItem.getQuantity(), lineItem.getPrice());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listLine;
	}
	
	public static Double computeOrderTotal(int orderId) {
		Connection cnn = null;
		CallableStatement cab = null;
		double result = 0d;
		try {
			cnn = JDBC.getConnections();
			String sql = "{? = call OrderTotal(?)}";
			cab = cnn.prepareCall(sql);
			cab.setInt(2, orderId);
			cab.registerOutParameter(1, Types.DOUBLE);
			cab.execute();
			result = cab.getDouble(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean addCustomer(Customer customer) {
		Connection cnn = null;
		CallableStatement cab = null;
		int n =0;
		try {
			cnn = JDBC.getConnections();
			String sql = "{Call addcustomer(?,?)}";
			cab = cnn.prepareCall(sql);
			cab.setInt(1, customer.getCustomerId());
			cab.setString(2, customer.getCustomerName());
			n = cab.executeUpdate();
			if (n>0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
