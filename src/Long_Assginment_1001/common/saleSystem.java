package Long_Assginment_1001.common;

import java.util.List;
import java.util.Scanner;

import Long_Assginment_1001.dao.Services;
import Long_Assginment_1001.entities.Customer;

public class saleSystem {
	public static void main(String[] args) {
//		List<Customer> listCus = Services.getAllCustomer();
//		for (Customer customer : listCus) {
//			System.out.println(customer.getCustomerId());
//		}
//		System.out.println(Services.computeOrderTotal(2));
		
//		Customer cs = new Customer(15, "Thanh Quynh");
//		System.out.println(Services.addCustomer(cs));
//		System.out.println(Services.deleteCustomer(3));
		
//		System.out.println(Services.updateCustomer(Services.changeCustomer(new Scanner(System.in))));
		
//		System.out.println(Services.addOrder(Services.createOrder(new Scanner(System.in))));
		
//		System.out.println(Services.addLineItem(Services.createLineItem(new Scanner(System.in))));
		
		System.out.println(Services.updateOrderTotal(2));
		
	}
}
