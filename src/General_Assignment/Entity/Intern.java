package General_Assignment.Entity;

import java.util.Scanner;

public class Intern extends Candidate{
	private String majors;
	private int semester;
	private String university_name;
	
	public Intern() {
		super.setCandidate_type(2);
	}

	

	public Intern(String candidateID, String fullName, String birthDay, String phone, String email, int candidate_type,
			String majors, int semester, String university_name) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		this.majors = majors;
		this.semester = semester;
		this.university_name = university_name;
		super.setCandidate_type(2);
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Enter majors");
		this.majors = sc.nextLine();
		System.out.println("Enter Semester");
		this.semester = Integer.parseInt(sc.nextLine());
		System.out.println("Enter University Name");
		this.university_name = sc.nextLine();
	}

	@Override
	public void showMe() {
		System.out.println("Candidate ID = " + super.getCandidateID()+ " " + super.getCandidate_type() + " " + toString()+ super.getCertificatedDate().toString() + super.getBirthDay());
	}

	

	@Override
	public String toString() {
		return "Intern [majors=" + majors + ", semester=" + semester + ", university_name=" + university_name + "]";
	}



	public String getMajors() {
		return majors;
	}



	public void setMajors(String majors) {
		this.majors = majors;
	}



	public int getSemester() {
		return semester;
	}



	public void setSemester(int semester) {
		this.semester = semester;
	}



	public String getUniversity_name() {
		return university_name;
	}



	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}
	
	
}
