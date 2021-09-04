package Long_Assginment_1001.common;

import java.util.List;
import java.util.Scanner;

import Long_Assginment_1001.dao.Services;
import Long_Assginment_1001.entities.Customer;
import Long_Assginment_902.Validator;
import Short_Assginment_501.validator;

public class saleSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cusID = 0;
		int orderID = 0;
		do {
			System.out.println("=================== SALE MANAGEMENT SYSTEM ==================");
			System.out.println("1. Get all customer");
			System.out.println("2. Get all order by customer");
			System.out.println("3. Get all Line Item ");
			System.out.println("4. Compute Order total");
			System.out.println("5. Add new Customer");
			System.out.println("6. Delete customer");
			System.out.println("7. Update customer");
			System.out.println("8. Create an Order");
			System.out.println("9. Create a Line Item");
			System.out.println("10. Update an Order");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				Services.getAllCustomer();
				break;
			case 2:
				System.out.println("Enter Customer ID");
				cusID = Validator.validateNumber();
				Services.getAllOrdersByCustomerId(cusID);
				break;
			case 3:
				System.out.println("Enter Customer ID");
				cusID = Validator.validateNumber();
				Services.getAllItemsByOrderId(cusID);
				break;
			case 4:
				System.out.println("Enter Order ID");
				orderID = Validator.validateNumber();
				System.out.println("Total of OderID" + orderID + " : " + Services.computeOrderTotal(orderID));
				break;
			case 5:
				Services.createCustomer(sc);
				break;
			case 6:
				System.out.println("Enter Customer ID want to delete");
				cusID = Validator.validateNumber();
				Services.deleteCustomer(cusID);
				break;
			case 7:
				Services.updateCustomer(Services.changeCustomer(sc));
				break;
			case 8:
				Services.createOrder(sc);
				break;
			case 9:
				Services.createLineItem(sc);
				break;
			case 10:
				System.out.println("Enter Order ID");
				orderID = Validator.validateNumber();
				Services.updateOrderTotal(orderID);
				break;
			case 0:
				System.exit(0);
			}
		}while (true);
	}
}
