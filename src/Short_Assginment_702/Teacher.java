package Short_Assginment_702;

import java.util.Scanner;

public class Teacher extends Person {
	private double basic_salary;
	private double subsidy;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, String gender, String phoneNumber, String email, double basic_salary, double subsidy) {
		super(name, gender, phoneNumber, email);
		this.basic_salary = basic_salary;
		this.subsidy = subsidy;
	}
	

	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Enter Basic Salary");
		this.basic_salary = Double.parseDouble(sc.nextLine());
		System.out.println("Enter Subsidy");
		this.subsidy = Double.parseDouble(sc.nextLine());
	}
	
	public double calculateSalary() {
		return (this.basic_salary + this.subsidy);
	}

	public double getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(double basic_salary) {
		this.basic_salary = basic_salary;
	}

	public double getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}
	
	
}
