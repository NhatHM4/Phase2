package Long_Assginment_901;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private String name;
	private String phoneNumber;
	private String address;
	private ArrayList<Order> order;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String phoneNumber, String address, ArrayList<Order> order) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.order = order;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		this.name = sc.nextLine();
		System.out.println("Enter phone");
		this.phoneNumber = sc.nextLine();
		System.out.println("Enter address");
		this.address = sc.nextLine();
		System.out.println("number of Order");
		int n = Integer.parseInt(sc.nextLine());
		order = new ArrayList<Order>();
		for (int i = 0; i < n; i++) {
			Order orde = new Order(); // khong the quen
			System.out.println("Enter code of Order");
			String number = sc.nextLine();
			orde.setNumber(number);
			System.out.println("Enter date of Order");
			String date = sc.nextLine();
			orde.setDate(date);
			order.add(orde);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Order> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<Order> order) {
		this.order = order;
	}

	public void output() {
		System.out.print("Name : " + this.name + " phone " + this.phoneNumber + " Address : " + this.address + " have "
				+ order.size() + " order : ");
		for (int i = 0; i < order.size(); i++) {
			System.out.print("number " + order.get(i).getNumber() + " ");
			System.out.print("date " + order.get(i).getDate() + " ");
			System.out.print("date " + order.get(i).getDate() + " ");
			System.out.println();
		}
	}

	public void displayData() {
		System.out.printf("|%-20s | %-20s | %-20s | %-20s |%n", this.name, this.address,this.phoneNumber,this.order.size() +" "+ this.order.toString());
	}
	

}
