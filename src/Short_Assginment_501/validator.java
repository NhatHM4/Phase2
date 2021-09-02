package Short_Assginment_501;

import java.util.Scanner;
import java.util.regex.Pattern;



public class validator {
	static Scanner sc = new Scanner(System.in);

	public static String validateCouseCode() {
		String courseCode = "";
		boolean aError = true;
		do {
			System.out.println("Enter Course Code ");
			courseCode = sc.nextLine();
			if ((Character.compare(courseCode.charAt(0), 'f') != 0)
					|| (Character.compare(courseCode.charAt(1), 'w') != 0) || courseCode.length() != 5) {
				aError = true;
			} else {
				for (int i = 2; i < 5; i++) {
					if (courseCode.charAt(i) == '0' || courseCode.charAt(i) == '1' || courseCode.charAt(i) == '2'
							|| courseCode.charAt(i) == '3' || courseCode.charAt(i) == '4' || courseCode.charAt(i) == '5'
							|| courseCode.charAt(i) == '6' || courseCode.charAt(i) == '7' || courseCode.charAt(i) == '8'
							|| courseCode.charAt(i) == '9') {
						aError = false;
					} else {
						aError = true;
					}
				}
			}
		} while (aError);
		return courseCode;
	}

	public static String validateStatus() {
		String status = "";
		boolean aError = true;
		do {
			System.out.println("Enter status of Course");
			status = sc.nextLine();
			if ((status.equals("active")) || (status.equals("in-active"))) {
				aError = false;
			}
		} while (aError);
		return status;
	}

	public static String validateFlag() {
		String flag = "";
		boolean aError = true;
		do {
			System.out.println("Enter flag of Course");
			flag = sc.nextLine();
			if ((flag.equals("optional") || (flag.equals("mandatory") || (flag.equals("N/A"))))) {
				aError = false;
			}
		} while (aError);
		return flag;
	}
	
	public static String validateCourseCode() {
		String CourseCode ="";
		Pattern p = Pattern.compile("^[Ff][Ww][0-9]{3}$");
		do {
			System.out.println("Enter Course Code");
			CourseCode = sc.nextLine();
			if (p.matcher(CourseCode).find()) {
				return CourseCode;
			} 
		}while (!p.matcher(CourseCode).find());
		return CourseCode;
	}
	public static void main(String[] args) {
		String name = validateCourseCode();
		System.out.println(name);
	}
}
