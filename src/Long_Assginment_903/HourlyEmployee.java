package Long_Assginment_903;

import java.util.Scanner;

public class HourlyEmployee extends Employee {
	private double wage;
	private double workingHours;
	
	public HourlyEmployee() {
		// TODO Auto-generated constructor stub
	}

	public HourlyEmployee(double wage, double workingHours) {
		super();
		this.wage = wage;
		this.workingHours = workingHours;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	
	@Override
	public void display() {
		System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",
				super.getSsn(), super.getFirstName(), super.getLastName(), super.getBirthDate(), super.getPhone(),
				super.getEmail(),this.wage,this.workingHours);
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Enter wage");
		this.wage = Double.parseDouble(sc.nextLine());
		System.out.println("Enter working hour");
		this.workingHours = Double.parseDouble(sc.nextLine());
		
	}
}
