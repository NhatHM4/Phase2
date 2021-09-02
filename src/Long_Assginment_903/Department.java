package Long_Assginment_903;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	private String departmentName;
	private ArrayList<Employee> listOfEmployee;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentName, ArrayList<Employee> listOfEmployee) {
		super();
		this.departmentName = departmentName;
		this.listOfEmployee = listOfEmployee;
	}

	public void input() {
		listOfEmployee = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter department Name");
		this.departmentName = sc.nextLine();
		String c = "";
		do {
			System.out.println("Choose option Employee want to add? 1.Salaried Employee 2.HourlyEmployee");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				SalariedEmployee sl = new SalariedEmployee();
				sl.input();
				listOfEmployee.add(sl);
				System.out.println("Do you want to continue? (Y/N)");
				c = sc.nextLine();
				break;
			case 2:
				HourlyEmployee he = new HourlyEmployee();
				he.input();
				listOfEmployee.add(he);
				System.out.println("Do you want to continue? (Y/N)");
				c = sc.nextLine();
				break;

			default:
				c = "Y";
			}
		} while (c.equalsIgnoreCase("Y"));
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public ArrayList<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(ArrayList<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}

	public void display() {
		System.out.println("DepartName : " + this.departmentName);
		if (checkContainSEMP()) {
			System.out.println("List of Salaried Employee:");
			System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "SSN",
					"First Name", "Last Name", "BirthDate", "Phone", "Email", "Salary", "Commisstion Rate",
					"Gross Sales");
			for (Employee employee : listOfEmployee) {
				if (employee instanceof SalariedEmployee) {
					employee.display();
				}
			}
		}
		if (checkContainHEMP()) {
			System.out.println("List of Hourly Employee:");
			System.out.printf("|%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "SSN", "First Name",
					"Last Name", "BirthDate", "Phone", "Email", "Wage", "Working Hour");
			for (Employee employee : listOfEmployee) {
				if (employee instanceof HourlyEmployee) {
					employee.display();
				}
			}
		}
		System.out.println();
	}

	private boolean checkContainSEMP() {
		for (Employee employee : listOfEmployee) {
			if (employee instanceof SalariedEmployee) {
				return true;
			}
		}
		return false;
	}

	private boolean checkContainHEMP() {
		for (Employee employee : listOfEmployee) {
			if (employee instanceof HourlyEmployee) {
				return true;
			}
		}
		return false;
	}
}
