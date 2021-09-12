package General_Assignment.Entity;

import java.util.ArrayList;
import java.util.Scanner;

import General_Assignment.Services.Validator;

public abstract class Candidate {
	private String candidateID;
	private String fullName;
	private String birthDay;
	private String phone;
	private String email;
	private int candidate_type;
	private static int count = 0;
	private ArrayList<Certificated> certificatedDate;
	
	public Candidate() {
		count++;
	}

	public abstract void showMe() ;
	
	public Candidate(String candidateID, String fullName, String birthDay, String phone, String email,
			int candidate_type) {
		super();
		this.candidateID = candidateID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.candidate_type = candidate_type;
		count++;
	}

	public void showInfo() {
		System.out.println(toString());
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Can ID");
		this.candidateID = sc.nextLine();
		System.out.println("Enter Fullname");
		this.fullName = sc.nextLine();
		System.out.println("Enter birthDay");
		this.birthDay = Validator.validLocalDate(sc.nextLine()).toString();
		System.out.println("Enter Phone");
		this.phone = sc.nextLine();
		System.out.println("Enter Email");
		this.email = Validator.validateEmail(sc);
		System.out.println("Enter number of Cer");
		certificatedDate = new ArrayList<Certificated>();
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Certificated ctf = new Certificated();
			ctf.input();
			certificatedDate.add(ctf);
		}
	}
	public String getCandidateID() {
		return candidateID;
	}

	
	
	@Override
	public String toString() {
		return "Candidate [candidateID=" + candidateID + ", fullName=" + fullName + ", birthDay=" + birthDay
				+ ", phone=" + phone + ", email=" + email + ", candidate_type=" + candidate_type + "]";
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCandidate_type() {
		return candidate_type;
	}

	public void setCandidate_type(int candidate_type) {
		this.candidate_type = candidate_type;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Candidate.count = count;
	}

	public ArrayList<Certificated> getCertificatedDate() {
		return certificatedDate;
	}

	public void setCertificatedDate(ArrayList<Certificated> certificatedDate) {
		this.certificatedDate = certificatedDate;
	}
	
	
}
