package General_Assignment.Entity;

import java.util.Scanner;

public class Fresher extends Candidate{
	private String Graduation_date;
	private String Graduation_rank;
	private String Education;
	public Fresher() {
		super.setCandidate_type(1);
	}
	
	
	
	public Fresher(String candidateID, String fullName, String birthDay, String phone, String email, int candidate_type,
			String graduation_date, String graduation_rank, String education) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		Graduation_date = graduation_date;
		Graduation_rank = graduation_rank;
		Education = education;
		super.setCandidate_type(1);
	}

	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Enter Graduation_date");
		this.Graduation_date = sc.nextLine();
		System.out.println("Enter Graduation_rank");
		this.Graduation_rank = sc.nextLine();
		System.out.println("Enter Education");
		this.Education = sc.nextLine();
	}


	public String getGraduation_date() {
		return Graduation_date;
	}



	public void setGraduation_date(String graduation_date) {
		Graduation_date = graduation_date;
	}



	public String getGraduation_rank() {
		return Graduation_rank;
	}



	public void setGraduation_rank(String graduation_rank) {
		Graduation_rank = graduation_rank;
	}



	public String getEducation() {
		return Education;
	}



	public void setEducation(String education) {
		Education = education;
	}



	@Override
	public void showMe() {
		System.out.println("Candidate ID = " + super.getCandidateID()+ " " + super.getCandidate_type() + " "+ toString()+ super.getCertificatedDate().toString() + super.getBirthDay());
		
	}



	@Override
	public String toString() {
		return "Fresher [Graduation_date=" + Graduation_date + ", Graduation_rank=" + Graduation_rank + ", Education="
				+ Education + "]";
	}
	
	

}
