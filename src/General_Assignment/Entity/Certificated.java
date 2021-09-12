package General_Assignment.Entity;

import java.util.Scanner;

public class Certificated {
	private String CertificatedID;
	private String CertificateName;
	private int CertificateRank;
	private String CertificatedDate;
	
	public Certificated() {
		// TODO Auto-generated constructor stub
	}

	public Certificated(String certificatedID, String certificateName, int certificateRank, String certificatedDate) {
		super();
		CertificatedID = certificatedID;
		CertificateName = certificateName;
		CertificateRank = certificateRank;
		CertificatedDate = certificatedDate;
	}

	public String getCertificatedID() {
		return CertificatedID;
	}

	public void setCertificatedID(String certificatedID) {
		CertificatedID = certificatedID;
	}

	public String getCertificateName() {
		return CertificateName;
	}

	public void setCertificateName(String certificateName) {
		CertificateName = certificateName;
	}

	public int getCertificateRank() {
		return CertificateRank;
	}

	public void setCertificateRank(int certificateRank) {
		CertificateRank = certificateRank;
	}

	public String getCertificatedDate() {
		return CertificatedDate;
	}

	public void setCertificatedDate(String certificatedDate) {
		CertificatedDate = certificatedDate;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Cer ID");
		this.CertificatedID = sc.nextLine();
		System.out.println("Enter Cer Name");
		this.CertificateName = sc.nextLine();
		System.out.println("Enter Cer rank");
		this.CertificateRank = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Cer date");
		this.CertificatedDate = sc.nextLine();
	}

	@Override
	public String toString() {
		return "Certificated [CertificatedID=" + CertificatedID + "]";
	}
	
	
	
}
