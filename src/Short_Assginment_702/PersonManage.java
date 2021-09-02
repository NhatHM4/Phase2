package Short_Assginment_702;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> listPerson = new ArrayList<Person>();
		do {
			System.out.println("1. Input data");
			System.out.println("2. Update student");
			System.out.println("3. Display teacher");
			System.out.println("4. Report");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				listPerson.add(input(sc));
				break;
			case 2:
				updateStudent(listPerson);
				break;
			case 3:
				displayTeacher(listPerson);
				break;
			case 4: 
				report(listPerson);
				break;
			case 5:
				showList(listPerson);
				break;
			case 0:
				System.exit(0);
			}
		} while (true);

	}

	private static void report(ArrayList<Person> listPerson) {
		for (Person person : listPerson) {
			if (person instanceof Student) {
				if (((Student) person).caculateFinalMark() > 6) {
					System.out.println("Student name : " + person.getName() + " Final Mark : " + ((Student) person).caculateFinalMark());
				}
			}
		}
	}

	private static void showList(ArrayList<Person> listPerson) {
		for (Person person : listPerson) {
			if (person instanceof Student) {
				System.out.println(((Student) person).getStudent_id() + " student" + ((Student) person).getPractice()
						+ " " + ((Student) person).getTheory());
			} else {
				System.out.println(person.getName() + " teacher");
			}
		}
	}

	private static Person input(Scanner sc) {
		Student std = null;
		Teacher tch = null;
		boolean aError = true;
		do {
			System.out.println("Input : 1.Student   2. Teacher");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				std = new Student();
				std.input();
				return std;
			case 2:
				tch = new Teacher();
				tch.input();
				return tch;
			default:
				aError = true;
			}
		} while (aError);
		return null;
	}

	public static void updateStudent(ArrayList<Person> listPerson) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID");
		String std_id = sc.nextLine();
		for (Person person : listPerson) {
			if (person instanceof Student) {
				if (((Student) person).getStudent_id().equals(std_id)) {
					System.out.println("What do you want to Update ? 1.Theory mark  2.Practice mark");
					int choose = Integer.parseInt(sc.nextLine());
					int mark = 0;
					switch (choose) {
					case 1:
						System.out.println("Enter theory mark you want to change");
						mark = Integer.parseInt(sc.nextLine());
						((Student) person).setTheory(mark);
						break;
					case 2:
						System.out.println("Enter practice mark you want to change");
						mark = Integer.parseInt(sc.nextLine());
						((Student) person).setPractice(mark);
						break;
					default:
						System.out.println("Ban nhap sai roi");
					}
				} else {
					System.out.println("Not exists student_id ");
				}
			} else {
				System.out.println("Not exsits student int List");
			}
		}
	}

	public static void displayTeacher(ArrayList<Person> listPerson) {
		Scanner sc = new Scanner(System.in);
		for (Person person : listPerson) {
			if (person instanceof Teacher) {
				if ((((Teacher) person).getBasic_salary() + ((Teacher) person).getSubsidy()) > 1000) {
					System.out.println(person.getName() + " " + ((Teacher) person).getBasic_salary()
							+ ((Teacher) person).getSubsidy());
				}
			}
		}
	}
}
