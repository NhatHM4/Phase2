package Long_Assginment_903;

import java.util.Scanner;

import Long_Assginment_902.Validator;

public abstract class Employee {
	private String ssn;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String phone;
	private String email;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter SSN");
		this.ssn = sc.nextLine();
		System.out.println("Enter First Name");
		this.firstName = sc.nextLine();
		System.out.println("Enter Last Name");
		this.lastName = sc.nextLine();
		System.out.println("Enter birthdate");
		this.birthDate = Validator.validDate(sc).toString();
		System.out.println("Enter phone ");
		this.phone = Validator.validatePhone(sc);
		System.out.println("Enter email");
		this.email = Validator.validateEmail(sc);
	}
	
	public abstract void display() ;
	
	public Employee(String ssn, String firstName, String lastName, String birthDate, String phone, String email) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
	}



	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
