package Long_Assginment_1001.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import JDBC.JDBC;
import Long_Assginment_1001.entities.Customer;
import Long_Assginment_1001.entities.LineItem;
import Long_Assginment_1001.entities.Order;
import Long_Assginment_1001.entities.Product;
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
			System.out.println("DONE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCus;
	}
	
	public static List<Product> getAllProduct(){
		List<Product> listCus = new ArrayList<Product>();
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			cnn = JDBC.getConnections();
			String sql = "select * from product";
			statement = cnn.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				Product cs = new Product();
				cs.setProductId(rs.getInt(1));
				cs.setProductName(rs.getString(2));
				cs.setListPrice(rs.getDouble(3));
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

	public static List<Order> getAllOrders() {
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
				order.setOrderId(rs.getInt("order_id"));
				order.setOrderDate(LocalDate.parse(rs.getString("order_date"),DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				order.setCustomerId(rs.getInt("customer_id"));
				order.setEmployeeId(rs.getInt("employee_id"));
				order.setTotal(rs.getDouble("total"));
				listOrder.add(order);
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
	
	public static Customer createCustomer(Scanner sc) {
		Customer cs = new Customer();
		cs.setCustomerId(getID()+1);
		System.out.println("Enter Customer name");
		String cusName = sc.nextLine();
		cs.setCustomerName(cusName);
		if (addCustomer(cs)) {
			System.out.println("Add succesfully");
		} else{
			System.out.println("Add failure");
		};
		return cs;
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
	public static boolean deleteCustomer(int customerId) {
		Connection cnn = null;
		CallableStatement cab = null;
		int count = 0;
		try {
			cnn = JDBC.getConnections();
			String sql = "{Call deletecustomer(?,?)}";
			cab = cnn.prepareCall(sql);
			cab.setInt(1, customerId);
			cab.registerOutParameter(2, java.sql.Types.INTEGER);
			cab.executeUpdate();
			count = cab.getInt(2);
			if (count >0) {
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
	
	public static Customer changeCustomer(Scanner sc) {
		Customer cs = new Customer();
		System.out.println("Enter Customer ID want to change");
		int cusID = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Customer name");
		String cusName = sc.nextLine();
		cs.setCustomerId(cusID);
		cs.setCustomerName(cusName);
		return cs;
	}
	
	public static boolean updateCustomer(Customer customer) {
		Connection cnn = null;
		CallableStatement cab = null;
		int count =0;
		try {
			cnn = JDBC.getConnections();
			String sql = "{Call updatecustomer(?,?)}";
			cab = cnn.prepareCall(sql);
			cab.setInt(1, customer.getCustomerId());
			cab.setString(2, customer.getCustomerName());
			count = cab.executeUpdate();
			if (count >0) {
				return true;
			} else {
				return false;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Order createOrder(Scanner sc) {
		Order od = new Order();
		int orderID = getIDOrder();
		od.setOrderId(orderID);
		System.out.println("Enter Order date");
		LocalDate date = Validator.validDate(sc);
		od.setOrderDate(date);
		System.out.println("Customer ID");
		int CusID = Integer.parseInt(sc.nextLine());
		od.setCustomerId(CusID);
		System.out.println("Employee ID");
		int empID = Integer.parseInt(sc.nextLine());
		od.setEmployeeId(empID);
		System.out.println("Enter total");
		double total = Double.parseDouble(sc.nextLine());
		od.setTotal(total);
		addOrder(od);
		return od;
	}
	
	public static boolean addOrder(Order order) {
		Connection cnn = null;
		PreparedStatement statement = null;
		int count =0;
		try {
			cnn = JDBC.getConnections();
			String sql = "insert into orders values(?,?,?,?,?)";
			statement = cnn.prepareStatement(sql);
			statement.setInt(1, order.getOrderId());
			statement.setDate(2,java.sql.Date.valueOf(order.getOrderDate()) );
			statement.setInt(3, order.getCustomerId());
			statement.setInt(4, order.getEmployeeId());
			statement.setDouble(5, order.getTotal());
			count = statement.executeUpdate();
			if (count >0) {
				return true;
			} else {
				return false;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static LineItem createLineItem(Scanner sc) {
		LineItem lt = new LineItem();
		int orderID = 0;
		do {
		System.out.println("Enter Order ID");
		 orderID = Integer.parseInt(sc.nextLine());
		} while (!checkContainOrderID(orderID));
		lt.setOrderId(orderID);
		int productID = 0;
		do {
		System.out.println("Enter product ID");
		productID = Integer.parseInt(sc.nextLine());
		} while (!checkContainProductID(productID));
		lt.setProductId(productID);
		System.out.println("Enter quantity");
		int quantity = Validator.validateNumber();
		lt.setQuantity(quantity);
		System.out.println("Enter price");
		double price = Double.parseDouble(sc.nextLine());
		lt.setPrice(price);
		addLineItem(lt);
		return lt;
	}
	
	private static boolean checkContainProductID(int productID) {
		List<Product> listProduct = getAllProduct();
		for (Product product : listProduct) {
			if (product.getProductId() == productID) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkContainOrderID(int orderID) {
		List<Order> listOrder = getAllOrders();
		for (Order order : listOrder) {
			if (order.getOrderId() == orderID) {
				return true;
			}
		}
		return false;
	}

	public static boolean addLineItem(LineItem item) {
		Connection cnn = null;
		PreparedStatement statement = null;
		int count =0;
		try {
			cnn = JDBC.getConnections();
			String sql = "insert into lineitem values(?,?,?,?)";
			statement = cnn.prepareStatement(sql);
			statement.setInt(1, item.getOrderId());
			statement.setInt(2, item.getProductId());
			statement.setInt(3, item.getQuantity());
			statement.setDouble(4, item.getPrice());
			count = statement.executeUpdate();
			if (count >0) {
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
	
	
	
	public static Order changeOrder(Scanner sc) {
		Order od = new Order();
		System.out.println("Enter Order ID want to change");
		int orderID = Integer.parseInt(sc.nextLine());
		od.setOrderId(orderID);
		System.out.println("Enter Order total want to update ");
		double total = Double.parseDouble(sc.nextLine());
		od.setTotal(total);
		return od;
	}
	
	public static boolean updateOrderTotal(int orderId) {
		Scanner sc = new Scanner(System.in);
		Connection cnn = null;
		PreparedStatement statement = null;
		int count = 0;
		try {
			cnn = JDBC.getConnections();
			System.out.println("Enter total want to update");
			double total = Double.parseDouble(sc.nextLine());
			String sql = "update orders set total = ? where order_id = ?";
			statement = cnn.prepareStatement(sql);
			statement.setInt(2, orderId);
			statement.setDouble(1, total);
			count = statement.executeUpdate();
			if (count >0) {
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
	
	public static int getID() {
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int id = 0;
		try {
			cnn = JDBC.getConnections();
			String sql = "select * from customer";
			statement = cnn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery();
			if (rs.last()) {
				id = rs.getInt(1);
				return id;
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	public static int getIDOrder() {
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int id = 0;
		try {
			cnn = JDBC.getConnections();
			String sql = "select * from orders";
			statement = cnn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery();
			if (rs.last()) {
				id = rs.getInt(1);
				return id;
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
}
