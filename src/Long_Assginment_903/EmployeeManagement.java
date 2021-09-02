package Long_Assginment_903;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.TargetDataLine;

public class EmployeeManagement {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		ArrayList<Department> listDeparment = new ArrayList<Department>();

		do {
			System.out.println();
			System.out.println("================== EMPLOYEE MANAGEMENT SYSTEM ==================");
			System.out.println("1. Add an employee");
			System.out.println("2. Display employee");
			System.out.println("3. Classify employee");
			System.out.println("4. Search employee");
			System.out.println("5. Display department");
			System.out.println("Enter your choose");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				Department dp = new Department();
				dp.input();
				listDeparment.add(dp);
				saveToFile(listDeparment);
				Thread.sleep(300);
				break;
			case 2:
				listDeparment = getdata();
				for (Department department : listDeparment) {
					department.display();
				}
				Thread.sleep(300);
				break;
			case 3:
				Classifyemployees();
				Thread.sleep(300);
				break;
			case 4:
				employeeSearch(sc);
				Thread.sleep(300);
				break;
			case 5:
				displayDepartment();
				Thread.sleep(300);
				break;
			}
		} while (true);
	}

	private static void displayDepartment() throws IOException {
		ArrayList<Department> listDeparment = getdata();
		if (listDeparment != null) {
			System.out.printf("| %-20s | %-20s |%n", "Department Name", "Number Of Employee");
			for (Department department : listDeparment) {
				System.out.printf("| %-20s | %-20s |%n", department.getDepartmentName(),
						department.getListOfEmployee().size());
			}
		}
	}

	private static void employeeSearch(Scanner sc) throws IOException {
		ArrayList<Department> listDeparment = getdata();
		System.out.println("What is the field want to search? 1. Department Name   2.Employee Name");
		int choose = Integer.parseInt(sc.nextLine());
		switch (choose) {
		case 1:
			System.out.println("Enter department name want to search");
			String depName = sc.nextLine();
			for (Department department : listDeparment) {
				if (department.getDepartmentName().equals(depName)) {
					department.display();
				}
			}
			break;
		case 2:
			System.out.println("Enter employee name want to search");
			String empName = sc.nextLine();
			if (checkContainSemp(listDeparment)) {
				System.out.println("List Employee Salaried Employee: ");
				System.out.printf("|%-20s |%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",
						"Department", "SSN", "First Name", "Last Name", "BirthDate", "Phone", "Email", "Salary",
						"Commisstion Rate", "Gross Sales");
				for (Department department : listDeparment) {
					for (Employee emp : department.getListOfEmployee()) {
						if (emp.getLastName().equals(empName)) {
							if (emp instanceof SalariedEmployee) {
								System.out.print("|" + department.getDepartmentName() + "                ");
								emp.display();
							}
						}
					}
				}
			}
			System.out.println();
			if (checkContainHemp(listDeparment)) {
				System.out.println("List Employee Hourly Employee: ");
				System.out.printf("|%-20s |%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",
						"Department", "SSN", "First Name", "LAST NAME", "BirthDate", "Phone", "Email", "Wage",
						"Working Hour");
				for (Department department : listDeparment) {
					for (Employee emp : department.getListOfEmployee()) {
						if (emp.getLastName().equals(empName)) {
							if (emp instanceof HourlyEmployee) {
								System.out.print("|" + department.getDepartmentName() + "                ");
								emp.display();
							}
						}
					}
				}
			}
			break;

		default:
			break;
		}

	}

	private static void Classifyemployees() throws IOException {
		ArrayList<Department> listDeparment = getdata();
		if (checkContainSemp(listDeparment)) {
			System.out.println("List Employee Salaried Employee: ");
			System.out.printf("|%-20s |%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n",
					"Department", "SSN", "First Name", "Last Name", "BirthDate", "Phone", "Email", "Salary",
					"Commisstion Rate", "Gross Sales");
			for (Department department : listDeparment) {
				for (Employee emp : department.getListOfEmployee()) {
					if (emp instanceof SalariedEmployee) {
						System.out.print("|" + department.getDepartmentName() + "                ");
						emp.display();
					}
				}
			}
		}
		System.out.println();
		if (checkContainHemp(listDeparment)) {
			System.out.println("List Employee Hourly Employee: ");
			System.out.printf("|%-20s |%-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Department",
					"SSN", "First Name", "Last Name", "BirthDate", "Phone", "Email", "Wage", "Working Hour");
			for (Department department : listDeparment) {
				for (Employee emp : department.getListOfEmployee()) {
					if (emp instanceof HourlyEmployee) {
						System.out.print("|" + department.getDepartmentName() + "                ");
						emp.display();
					}
				}
			}
		}

	}

	private static boolean checkContainSemp(ArrayList<Department> listDeparment) {
		for (Department department : listDeparment) {
			for (Employee emp : department.getListOfEmployee()) {
				if (emp instanceof SalariedEmployee) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkContainHemp(ArrayList<Department> listDeparment) {
		for (Department department : listDeparment) {
			for (Employee emp : department.getListOfEmployee()) {
				if (emp instanceof HourlyEmployee) {
					return true;
				}
			}
		}
		return false;
	}

	private static ArrayList<Department> getdata() throws IOException {
		ArrayList<Department> listDeparment = new ArrayList<Department>();
		String line1 = "";
		String line2 = "";
		String line3 = "";
		try {
			BufferedReader bff1 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\Phase 2\\JPE\\Department.txt"));
			while ((line1 = bff1.readLine()) != null) {
				Department dp = new Department();
				String[] data = line1.split(" ");
				dp.setDepartmentName(data[0]);
				BufferedReader bff2 = new BufferedReader(
						new FileReader("E:\\hoc lap trinh\\Phase 2\\JPE\\SalariedEmpolyee.txt"));
				ArrayList<Employee> listSEMP = new ArrayList<Employee>();
				while ((line2 = bff2.readLine()) != null) {
					String[] data1 = line2.split(" ");
					if (data[0].equals(data1[0])) {
						SalariedEmployee sEmp = new SalariedEmployee();
						sEmp.setSsn(data1[1]);
						sEmp.setFirstName(data1[2]);
						sEmp.setLastName(data1[3]);
						sEmp.setBirthDate(data1[4]);
						sEmp.setPhone(data1[5]);
						sEmp.setEmail(data1[6]);
						sEmp.setCommisstionRate(Double.parseDouble(data1[7]));
						sEmp.setGrossSales(Double.parseDouble(data1[8]));
						sEmp.setBasicSalary(Double.parseDouble(data1[9]));
						listSEMP.add(sEmp);
					}
				}
				BufferedReader bff3 = new BufferedReader(
						new FileReader("E:\\hoc lap trinh\\Phase 2\\JPE\\HourlyEmployee.txt"));
				while ((line3 = bff3.readLine()) != null) {
//					bff3.mark(0);
					String[] data2 = line3.split(" ");
					if (data[0].equals(data2[0])) {
						HourlyEmployee hEmp = new HourlyEmployee();
						hEmp.setSsn(data2[1]);
						hEmp.setFirstName(data2[2]);
						hEmp.setLastName(data2[3]);
						hEmp.setBirthDate(data2[4]);
						hEmp.setPhone(data2[5]);
						hEmp.setEmail(data2[6]);
						hEmp.setWage(Double.parseDouble(data2[7]));
						hEmp.setWorkingHours(Double.parseDouble(data2[8]));
						listSEMP.add(hEmp);
					}
//					bff3.reset();
				}
				dp.setListOfEmployee(listSEMP);
				listDeparment.add(dp);
				bff2.close();
				bff3.close();
			}
			bff1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listDeparment;
	}

	private static void saveToFile(ArrayList<Department> listDeparment) {
		File file1 = new File("E:\\hoc lap trinh\\Phase 2\\JPE\\Department.txt");
		File file2 = new File("E:\\hoc lap trinh\\Phase 2\\JPE\\HourlyEmployee.txt");
		File file3 = new File("E:\\hoc lap trinh\\Phase 2\\JPE\\SalariedEmpolyee.txt");
		try {
			OutputStream outputStream1 = new FileOutputStream(file1);
			OutputStream outputStream2 = new FileOutputStream(file2);
			OutputStream outputStream3 = new FileOutputStream(file3);
			OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(outputStream1);
			OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(outputStream2);
			OutputStreamWriter outputStreamWriter3 = new OutputStreamWriter(outputStream3);
			for (Department department : listDeparment) {
				try {
					outputStreamWriter1.write(department.getDepartmentName());
					outputStreamWriter1.write("\n");
					for (Employee emp : department.getListOfEmployee()) {
						if (emp instanceof HourlyEmployee) {
							outputStreamWriter2.write(department.getDepartmentName() + " ");
							outputStreamWriter2.write(emp.getSsn() + " ");
							outputStreamWriter2.write(emp.getFirstName() + " ");
							outputStreamWriter2.write(emp.getLastName() + " ");
							outputStreamWriter2.write(emp.getBirthDate() + " ");
							outputStreamWriter2.write(emp.getPhone() + " ");
							outputStreamWriter2.write(emp.getEmail() + " ");
							outputStreamWriter2.write(((HourlyEmployee) emp).getWage() + " ");
							outputStreamWriter2.write(((HourlyEmployee) emp).getWorkingHours() + " ");
							outputStreamWriter2.write("\n");
						} else {
							outputStreamWriter3.write(department.getDepartmentName() + " ");
							outputStreamWriter3.write(emp.getSsn() + " ");
							outputStreamWriter3.write(emp.getFirstName() + " ");
							outputStreamWriter3.write(emp.getLastName() + " ");
							outputStreamWriter3.write(emp.getBirthDate() + " ");
							outputStreamWriter3.write(emp.getPhone() + " ");
							outputStreamWriter3.write(emp.getEmail() + " ");
							outputStreamWriter3.write(((SalariedEmployee) emp).getCommisstionRate() + " ");
							outputStreamWriter3.write(((SalariedEmployee) emp).getGrossSales() + " ");
							outputStreamWriter3.write(((SalariedEmployee) emp).getBasicSalary() + " ");
							outputStreamWriter3.write("\n");
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					outputStreamWriter1.flush();
					outputStreamWriter2.flush();
					outputStreamWriter3.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
