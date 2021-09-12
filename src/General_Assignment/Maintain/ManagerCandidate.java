package General_Assignment.Maintain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import General_Assignment.Entity.Candidate;
import General_Assignment.Entity.Certificated;
import General_Assignment.Entity.Experience;
import General_Assignment.Entity.Fresher;
import General_Assignment.Entity.Intern;
import General_Assignment.Services.JDBC;

public class ManagerCandidate {
	public static void main(String[] args) {
//		Certificated cs = new Certificated("1", "2", 2, "2021-09-11");
//		savetoDBCertificate(cs, "1");
		Scanner sc = new Scanner(System.in);
		List<Candidate> listCandidate = new ArrayList<Candidate>();
		do {
			System.out.println("Enter your option");
			int choose = Integer.parseInt(sc.nextLine());
			switch (choose) {
			case 1:
				createCandidate(sc);
				break;
			case 2:
				listCandidate = findAll();
				break;
			case 3:
				showData(listCandidate);
				break;
			case 4:
				sortCandidate(listCandidate);
				break;
			default:
				break;
			}
		} while (true);
	}

	private static void sortCandidate(List<Candidate> listCandidate) {
		Collections.sort(listCandidate, new sortByCandidate_type());
		for (Candidate candidate : listCandidate) {
			candidate.showMe();
		}
	}
	


	private static void showData(List<Candidate> listCandidate) {
		for (Candidate candidate : listCandidate) {
			candidate.showMe();
		}
	}

	private static List<Candidate> findAll() {
		List<Candidate> listCandidate = new ArrayList<Candidate>();
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			cnn =JDBC.getConnections();
			String sql = "select * from Candidate";
			statement = cnn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getInt("Candidate_type") == 0) {
					Experience exp = new Experience();
					exp.setCandidateID(rs.getString("CandidateID"));
					exp.setFullName(rs.getString("FullName"));
					exp.setBirthDay(rs.getString("BirthDay"));
					exp.setPhone(rs.getString("Phone"));
					exp.setEmail(rs.getString("Email"));
					exp.setCandidate_type(rs.getInt("Candidate_type"));
					exp.setExpInYear(rs.getInt("ExpInYear"));
					exp.setProSkill(rs.getString("ProSkill"));
					exp.setCertificatedDate(getListCertificated(rs.getString("CandidateID")));
					listCandidate.add(exp);
				} else if (rs.getInt("Candidate_type") == 1) {
					Fresher fr = new Fresher();
					fr.setCandidateID(rs.getString("CandidateID"));
					fr.setFullName(rs.getString("FullName"));
					fr.setBirthDay(rs.getString("BirthDay"));
					fr.setPhone(rs.getString("Phone"));
					fr.setEmail(rs.getString("Email"));
					fr.setCandidate_type(rs.getInt("Candidate_type"));
					fr.setGraduation_date(rs.getString("Graduation_date"));
					fr.setGraduation_rank(rs.getString("Graduation_rank"));
					fr.setEducation(rs.getString("Education"));
					fr.setCertificatedDate(getListCertificated(rs.getString("CandidateID")));
					listCandidate.add(fr);
				} else {
					Intern intern = new Intern();
					intern.setCandidateID(rs.getString("CandidateID"));
					intern.setFullName(rs.getString("FullName"));
					intern.setBirthDay(rs.getString("BirthDay"));
					intern.setPhone(rs.getString("Phone"));
					intern.setEmail(rs.getString("Email"));
					intern.setCandidate_type(rs.getInt("Candidate_type"));
					intern.setMajors(rs.getString("Majors"));
					intern.setSemester(rs.getInt("Semester"));
					intern.setUniversity_name(rs.getString("University_name"));
					intern.setCertificatedDate(getListCertificated(rs.getString("CandidateID")));
					listCandidate.add(intern);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCandidate;
		
	}

	private static ArrayList<Certificated> getListCertificated(String candidateID) {
		ArrayList<Certificated> listCertificated = new ArrayList<Certificated>();
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			cnn =JDBC.getConnections();
			String sql = "select * from Certificated";
			statement = cnn.prepareStatement(sql);
			rs = statement.executeQuery();
			while(rs.next()) {
				if (rs.getString("CandidateID").equals(candidateID)) {
					Certificated ctf = new Certificated();
					ctf.setCertificatedID(rs.getString("CertificatedID"));
					ctf.setCertificateName(rs.getString("CertificateName"));
					ctf.setCertificateRank(rs.getInt("CertificateRank"));
					ctf.setCertificatedDate(rs.getString("CertificatedDate"));
					listCertificated.add(ctf);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCertificated;
	}

	private static void createCandidate(Scanner sc) {
		int chose = Integer.parseInt(sc.nextLine());
		switch (chose) {
		case 1:
			Candidate exp = new Experience();
			exp.input();
			saveToDB(exp);
			break;
		case 2:
			Candidate fr = new Fresher();
			fr.input();
			saveToDB(fr);
			break;
		case 3:
			Candidate intern = new Intern();
			intern.input();
			saveToDB(intern);
			break;
		default:
			break;
		}
	}

	private static void saveToDB(Candidate cand) {

		Connection cnn = null;
		PreparedStatement statement = null;
		Savepoint spt1 = null;
		try {
			cnn = JDBC.getConnections();
			cnn.setAutoCommit(false);
//			spt1 = cnn.setSavepoint("svpt1");
			if (cand instanceof Experience) {
				String sql = "insert into Candidate(CandidateID,FullName,BirthDay,Phone,Email,Candidate_type,ExpInYear,ProSkill) values(?,?,?,?,?,?,?,?)";
				statement = cnn.prepareStatement(sql);
				statement.setString(1, cand.getCandidateID());
				statement.setString(2, cand.getFullName());
				statement.setString(3, cand.getBirthDay());
				statement.setString(4, cand.getPhone());
				statement.setString(5, cand.getEmail());
				statement.setInt(6, cand.getCandidate_type());
				statement.setInt(7, ((Experience) cand).getExpInYear());
				statement.setString(8, ((Experience) cand).getProSkill());
				int rs = statement.executeUpdate();
				if (rs > 0) {
					System.out.println("Successfully");
				} else {
					System.out.println("Fail");
				}
			} else if (cand instanceof Fresher) {
				String sql = "insert into Candidate(CandidateID,FullName,BirthDay,Phone,Email,Candidate_type,Graduation_date,Graduation_rank,Education) values(?,?,?,?,?,?,?,?,?)";
				statement = cnn.prepareStatement(sql);
				statement.setString(1, cand.getCandidateID());
				statement.setString(2, cand.getFullName());
				statement.setString(3, cand.getBirthDay());
				statement.setString(4, cand.getPhone());
				statement.setString(5, cand.getEmail());
				statement.setInt(6, cand.getCandidate_type());
				statement.setString(7, ((Fresher) cand).getGraduation_date());
				statement.setString(8, ((Fresher) cand).getGraduation_rank());
				statement.setString(9, ((Fresher) cand).getEducation());
				int rs = statement.executeUpdate();
				if (rs > 0) {
					System.out.println("Successfully");
				} else {
					System.out.println("Fail");
				}
			} else {
				String sql = "insert into Candidate(CandidateID,FullName,BirthDay,Phone,Email,Candidate_type,Majors,Semester,University_name) values(?,?,?,?,?,?,?,?,?)";
				statement = cnn.prepareStatement(sql);
				statement.setString(1, cand.getCandidateID());
				statement.setString(2, cand.getFullName());
				statement.setString(3, cand.getBirthDay());
				statement.setString(4, cand.getPhone());
				statement.setString(5, cand.getEmail());
				statement.setInt(6, cand.getCandidate_type());
				statement.setString(7, ((Intern) cand).getMajors());
				statement.setInt(8, ((Intern) cand).getSemester());
				statement.setString(9, ((Intern) cand).getUniversity_name());
				int rs = statement.executeUpdate();
				if (rs > 0) {
					System.out.println("Successfully");
				} else {
					System.out.println("Fail");
				}
			}
			
			for (Certificated cer : cand.getCertificatedDate()) {
				savetoDBCertificate(cer, cand.getCandidateID(), cnn);
			}
			cnn.commit();
		} catch (SQLException e) {
			if (cnn != null) {
				try {
					cnn.rollback();
				} // rollback on error
				catch (SQLException i) {
				}
			}
			e.printStackTrace();

		}

	}

	private static void savetoDBCertificate(Certificated cer, String candidateID, Connection cnn) {

		PreparedStatement statement = null;
		try {
//			cnn = JDBC.getConnections();
			cnn.setAutoCommit(false);
			String sql = "insert into Certificated values(?,?,?,?,?)";
			statement = cnn.prepareStatement(sql);
			statement.setString(1, cer.getCertificatedID());
			statement.setString(2, cer.getCertificateName());
			statement.setInt(3, cer.getCertificateRank());
			statement.setString(4, cer.getCertificatedDate());
			statement.setString(5, candidateID);
			statement.executeUpdate();
			cnn.commit();
		} catch (SQLException e) {
			if (cnn != null) {
				try {
					cnn.rollback();
				} // rollback on error
				catch (SQLException i) {
				}
			}
			e.printStackTrace();
		}
	}

}

class sortByCandidate_type implements Comparator<Candidate> {

	@Override
	public int compare(Candidate o1, Candidate o2) {
		if (o1.getCandidate_type() > o2.getCandidate_type()) {
			return 1;
		} else if (o1.getCandidate_type() < o2.getCandidate_type()) {
			return -1;
		} else {
			if (Integer.parseInt(o1.getBirthDay().substring(0,4)) > Integer.parseInt(o2.getBirthDay().substring(0, 4))) {
				return 1;
			} else if (Integer.parseInt(o1.getBirthDay().substring(0,4)) < Integer.parseInt(o2.getBirthDay().substring(0, 4))) {
				return -1;
			} else return 0;
		}
	}
	
}
