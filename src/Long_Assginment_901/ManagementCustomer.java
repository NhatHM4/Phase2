package Long_Assginment_901;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManagementCustomer {
	public static final String CUSTOMER = "D:\\Customer.txt";
	public static final String ORDER  = "D:\\Order.txt";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Customer> listCus = new ArrayList<Customer>();
		do {
			System.out.println("================== CUSTOMER MANAGEMENT SYSTEM ==================");
			System.out.println("1. Create new customer");
			System.out.println("2. Save data into Text");
			System.out.println("3. Display customer");
			System.out.println("4. Search customer");
			System.out.println("5. Remove customer");
			System.out.println("================================================================");
			System.out.println("Enter your option");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				listCus = creaCustomer(sc);
				break;
			case 2:
				save(listCus);
				break;
			case 6:
				listCus = findAll();
				break;
			case 3:
				show(listCus);
				break;
			case 4:
				System.out.println("Enter phone want to search");
				String phone = sc.nextLine();
				search(phone);
				break;
			case 5:
				System.out.println("Enter phone want to remove");
				String phoneNumber = sc.nextLine();
				remove(phoneNumber);
				break;
			case 0:
				System.exit(0);
			}
		} while (true);

	}

	private static void remove(String phoneNumber) {
		List<Customer> listCus = findAll();
		for (int i = 0; i < listCus.size(); i++) {
			if (listCus.get(i).getPhoneNumber().equals(phoneNumber)) {
				listCus.remove(i);
				System.out.println("1");
			}
		}
		save(listCus);
		
	}

	private static void search(String phone) {
		List<Customer> listCus = findAll();
		Collections.sort(listCus, new Comparator<Customer>() {

			@Override
			public int compare(Customer o1, Customer o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.printf("|%-20s | %-20s | %-20s | %-20s |%n", "Customer Name", "Address", "Phone Number",
				"OrderList");
		for (Customer customer : listCus) {
			if (customer.getPhoneNumber().equals(phone)) {
				customer.displayData();
			}
		}
	}

	private static List<Customer> findAll() {
		List<Customer> listCus = new ArrayList<Customer>();
		ArrayList<Order> listOrder = null;
		String line = "";
		String line2 = "";
		BufferedReader bff = null;
		BufferedReader bff2 = null;
		try {
			bff = new BufferedReader(new FileReader(CUSTOMER));
			try {
				while ((line = bff.readLine()) != null) {
					Customer cs = new Customer();
					String[] data = line.split(" ");
					cs.setName(data[0]);
					cs.setPhoneNumber(data[1]);
					cs.setAddress(data[2]);
					bff2 = new BufferedReader(new FileReader(ORDER));
					listOrder = new ArrayList<Order>();
					while ((line2 = bff2.readLine()) != null) {
						String[] data1 = line2.split(" ");
						if (data[0].equals(data1[0])) {
							Order order = new Order();
							order.setNumber(data1[1]);
							order.setDate(data1[2]);
							listOrder.add(order);
						}
					}
					cs.setOrder(listOrder);
					listCus.add(cs);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCus;
	}

	private static void show(List<Customer> listCus) {
		listCus = findAll();
		System.out.printf("|%-20s | %-20s | %-20s | %-20s |%n", "Customer Name", "Address", "Phone Number",
				"OrderList");
		for (Customer customer : listCus) {
			customer.displayData();
		}
	}

	private static List<Customer> creaCustomer(Scanner sc) {
		List<Customer> listCus =findAll();
		String c;
		do {
			Customer cs = new Customer();
			cs.input();
			listCus.add(cs);
			System.out.println("Do you want to continue (Y/N)?");
			c = sc.nextLine();
		} while (!c.equalsIgnoreCase("n"));
		return listCus;
	}

	private static void save(List<Customer> listCus) {
		File file = null;
		File file2 = null;
		OutputStream outputStream = null;
		OutputStream outputStream2 = null;
		OutputStreamWriter outputStreamWriter = null;
		OutputStreamWriter outputStreamWriter2 = null;
		try {
			file = new File(CUSTOMER);
			file2 = new File(ORDER);
			outputStream = new FileOutputStream(file);
			outputStream2 = new FileOutputStream(file2);
			outputStreamWriter = new OutputStreamWriter(outputStream);
			for (Customer customer : listCus) {
				try {
					outputStreamWriter.write(customer.getName() + " ");
					outputStreamWriter.write(customer.getPhoneNumber() + " ");
					outputStreamWriter.write(customer.getAddress() + " ");
					outputStreamWriter2 = new OutputStreamWriter(outputStream2);
					for (int j = 0; j < customer.getOrder().size(); j++) {
						outputStreamWriter2.write(customer.getName() + " ");
						outputStreamWriter2.write(customer.getOrder().get(j).getNumber() + " ");
						outputStreamWriter2.write(customer.getOrder().get(j).getDate() + " ");
						outputStreamWriter2.write("\n");
					}
					outputStreamWriter.write("\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						outputStreamWriter.flush();
						outputStreamWriter2.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			try {
				outputStreamWriter.close();
				outputStreamWriter2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
