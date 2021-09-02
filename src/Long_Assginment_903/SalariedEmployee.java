package Long_Assginment_903;

import java.util.Scanner;

public class SalariedEmployee extends Employee {
	private double commisstionRate;
	private double grossSales;
	private double basicSalary;

	public SalariedEmployee() {
		// TODO Auto-generated constructor stub
	}

	public SalariedEmployee(double commisstionRate, double grossSales, double basicSalary) {
		super();
		this.commisstionRate = commisstionRate;
		this.grossSales = grossSales;
		this.basicSalary = basicSalary;
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Enter commisstionRate");
		this.commisstionRate = Double.parseDouble(sc.nextLine());
		System.out.println("Enter grossSales");
		this.grossSales = Double.parseDouble(sc.nextLine());
		System.out.println("Enter basicSalary");
		this.basicSalary = Double.parseDouble(sc.nextLine());
		
	}
	public double getCommisstionRate() {
		return commisstionRate;
	}

	public void setCommisstionRate(double commisstionRate) {
		this.commisstionRate = commisstionRate;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",
				super.getSsn(), super.getFirstName(), super.getLastName(), super.getBirthDate(), super.getPhone(),
				super.getEmail(),this.basicSalary,this.commisstionRate,this.grossSales);
	}

		

}
