package Short_Assginment_501;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Couse> listCourse = new ArrayList<Couse>();
		System.out.println("Enter number of Course");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Couse cs = new Couse();
			cs.input();
			listCourse.add(cs);
		}
		for (Couse couse : listCourse) {
			System.out.println(couse.toString());
		}
		do {
			System.out.println("Enter attribute name");
			String attributteName = sc.nextLine();
			find(attributteName, listCourse);
			showFlag(listCourse);
		} while (true);
		
	}

	public static void showFlag(ArrayList<Couse> listCourse) {
		for (Couse couse : listCourse) {
			if (couse.getFlag().equals("mandatory")) {
				System.out.println(couse.toString());
			}
		}
	}
	
	
	public static void find(String type, ArrayList<Couse> listCourse) {
		if (!checkIsNumber(type)) {
			for (Couse couse : listCourse) {
				if (couse.getCourseCode().equals(type) || couse.getCourseName().equals(type)
						|| couse.getFlag().equals(type) || couse.getStatus().equals(type)) {
					System.out.println(couse.toString());
				}
			}
		} else {
			for (Couse couse : listCourse) {
				if (couse.getDuration() == Double.parseDouble(type)) {
					System.out.println(couse.toString());
				}
			}
		}
	}

	public static boolean checkIsNumber(String value) {
		int transValue = 0;
		try {
			transValue = Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
