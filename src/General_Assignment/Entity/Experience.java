package General_Assignment.Entity;

import java.util.Scanner;

public class Experience extends Candidate {
	private int expInYear;
	private String ProSkill;
	
	public Experience() {
		super.setCandidate_type(0);
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Enter Experience in Year");
		this.expInYear = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Pro Skill ");
		this.ProSkill = sc.nextLine();
	}

	public int getExpInYear() {
		return expInYear;
	}


	public Experience(String candidateID, String fullName, String birthDay, String phone, String email,
			int candidate_type, int expInYear, String proSkill) {
		super(candidateID, fullName, birthDay, phone, email, candidate_type);
		this.expInYear = expInYear;
		ProSkill = proSkill;
		super.setCandidate_type(0);
	}


	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}


	public String getProSkill() {
		return ProSkill;
	}


	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}


	@Override
	public void showMe() {
		System.out.println("Cadidate ID " + super.getCandidate_type()+ " " + super.getCandidate_type() + " " + toString() + super.getCertificatedDate().toString() + super.getBirthDay());
	}


	@Override
	public String toString() {
		return "Experience [expInYear=" + expInYear + ", ProSkill=" + ProSkill + "]";
	}


	
	
}
