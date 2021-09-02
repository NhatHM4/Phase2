package Short_Assginment_702;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Student extends Person {
	private String student_id;
	private double theory;
	private double practice;

	public Student(String name, String gender, String phoneNumber, String email, String student_id, double theory,
			double practice) {
		super(name, gender, phoneNumber, email);
		this.student_id = student_id;
		this.theory = theory;
		this.practice = practice;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Enter Student ID");
		this.student_id = sc.nextLine();
		System.out.println("Enter mark theory");
		this.theory = validateMark(sc);
		System.out.println("Enter mark practice");
		this.practice = validateMark(sc);
	}

	public static double validateMark(Scanner sc) {
		double mark = 0;
		Pattern p;
		do {
			mark = Double.parseDouble(sc.nextLine());
			p = Pattern.compile("^([0-9]|10)([.][0-9]+)$");
			if (p.matcher((mark+"")).find()) {
				return mark;
			} 
			
		} while (!p.matcher((mark+"")).find());
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double name  = validateMark(sc);
		System.out.println(name);
	}

	public double caculateFinalMark() {
		return (this.theory + this.practice) / 2;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public double getTheory() {
		return theory;
	}

	public void setTheory(double theory) {
		this.theory = theory;
	}

	public double getPractice() {
		return practice;
	}

	public void setPractice(double practice) {
		this.practice = practice;
	}

}
