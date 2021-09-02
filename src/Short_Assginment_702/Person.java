package Short_Assginment_702;

import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Person {
	private String name;
	private String gender;
	private String phoneNumber;
	private String email;

//	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, String gender, String phoneNumber, String email) {
		this.name = name;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name person");
		this.name = sc.nextLine();
		System.out.println("Enter gender person");
		this.gender = sc.nextLine();
		System.out.println("Enter phone number");
		this.phoneNumber = sc.nextLine();
		this.email = validateEmail(sc);
	}

	public String validateEmail(Scanner sc) {
		String email1 = "";
		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-z]+(\\.[a-zA-Z]+)+$");
		do {
			System.out.println("Enter email");
			email1 = sc.nextLine();
			if (p.matcher(email1).find()) {
				return email1;
			}
		} while (!(p.matcher(email1).find()));
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void purchaseParkingPass() {

	}
}
