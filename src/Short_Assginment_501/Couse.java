package Short_Assginment_501;

import java.util.Scanner;

public class Couse {
	private String courseCode;
	private String courseName;
	private double duration;
	private String status;
	private String flag;
	
	public Couse() {
		// TODO Auto-generated constructor stub
		this.courseCode = null;
		this.courseName = null;
		this.duration = 0d;
		this.status = null;
		this.flag = null;
	}

	public Couse(String courseCode, String courseName, double duration, String status, String flag) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.duration = duration;
		this.status = status;
		this.flag = flag;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return courseCode + " " + courseName + " " + duration + " " + status + " " + flag;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		this.courseCode = validator.validateCourseCode();
		System.out.println("Enter name of Course");
		this.courseName = sc.nextLine();
		System.out.println("Enter duration of Course");
		this.duration = Double.parseDouble(sc.nextLine());
		this.status = validator.validateStatus();
		this.flag = validator.validateFlag();
	}
	
	
}	
