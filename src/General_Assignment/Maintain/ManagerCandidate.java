package General_Assignment.Maintain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
			case 5:
				updateNonSQLQuery(sc);
				break;
			case 6:
				insertCandidateNonSQLQuery(new Fresher());
				break;
			case 7:
				try {
					saveToFile(listCandidate);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				try {
					listCandidate = findDataToJava();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} while (true);
	}

	private static List<Candidate> findDataToJava() throws IOException {
		List<Candidate> listCandidate = new ArrayList<Candidate>();
		String line1 = "";
		String line2 = "";
		String line3 = "";
		BufferedReader bff1 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\Phase 2\\JPE\\Experience.txt"));
		while ((line1 = bff1.readLine()) != null) {
			Experience exp = new Experience();
			String[] data1 = line1.split(" ");
			exp.setCandidateID(data1[0]);
			exp.setFullName(data1[1]);
			exp.setBirthDay(data1[2]);
			exp.setPhone(data1[3]);
			exp.setEmail(data1[4]);
			exp.setCandidate_type(Integer.parseInt(data1[5]));
			exp.setExpInYear(Integer.parseInt(data1[6]));
			exp.setProSkill(data1[7]);
			exp.setCertificatedDate(getLisCer(data1[0]));
			listCandidate.add(exp);
		}
		BufferedReader bff2 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\Phase 2\\JPE\\Fresher.txt"));
		while ((line2 = bff2.readLine()) != null) {
			Fresher fr = new Fresher();
			String[] data1 = line2.split(" ");
			fr.setCandidateID(data1[0]);
			fr.setFullName(data1[1]);
			fr.setBirthDay(data1[2]);
			fr.setPhone(data1[3]);
			fr.setEmail(data1[4]);
			fr.setCandidate_type(Integer.parseInt(data1[5]));
			fr.setGraduation_date(data1[6]);
			fr.setGraduation_rank(data1[7]);
			fr.setEducation(data1[8]);
			fr.setCertificatedDate(getLisCer(data1[0]));
			listCandidate.add(fr);
		}
		BufferedReader bff3 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\Phase 2\\JPE\\Intern.txt"));
		while ((line3 = bff3.readLine()) != null) {
			Intern in = new Intern();
			String[] data1 = line3.split(" ");
			in.setCandidateID(data1[0]);
			in.setFullName(data1[1]);
			in.setBirthDay(data1[2]);
			in.setPhone(data1[3]);
			in.setEmail(data1[4]);
			in.setCandidate_type(Integer.parseInt(data1[5]));
			in.setMajors(data1[6]);
			in.setSemester(Integer.parseInt(data1[7]));
			in.setUniversity_name(data1[8]);
			in.setCertificatedDate(getLisCer(data1[0]));
			listCandidate.add(in);
		}
		bff1.close();
		bff2.close();
		bff3.close();
		return listCandidate;
	}

	private static ArrayList<Certificated> getLisCer(String string) throws IOException {
		ArrayList<Certificated> listCer = new ArrayList<Certificated>();
		String line1 = "";
		BufferedReader bff1 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\Phase 2\\JPE\\Certificate.txt"));
		while ((line1 = bff1.readLine()) != null) {
			Certificated ctf = new Certificated();
			String[] data1 = line1.split(" ");
			if (data1[4].equals(string)) {
				ctf.setCertificatedID(data1[0]);
				ctf.setCertificateName(data1[1]);
				ctf.setCertificateRank(Integer.parseInt(data1[2]));
				ctf.setCertificatedDate(data1[3]);
				listCer.add(ctf);
			}
		}
		return listCer;
	}

	private static void saveToFile(List<Candidate> listCandidate) throws IOException {
		File file1 = new File("E:\\hoc lap trinh\\Phase 2\\JPE\\Experience.txt");
		File file2 = new File("E:\\hoc lap trinh\\Phase 2\\JPE\\Fresher.txt");
		File file3 = new File("E:\\hoc lap trinh\\Phase 2\\JPE\\Intern.txt");
		File file4 = new File("E:\\hoc lap trinh\\Phase 2\\JPE\\Certificate.txt");
		OutputStream outputStream1 = null;
		OutputStream outputStream2 = null;
		OutputStream outputStream3 = null;
		OutputStream outputStream4 = null;
		OutputStreamWriter outputStreamWriter1 = null;
		OutputStreamWriter outputStreamWriter2 = null;
		OutputStreamWriter outputStreamWriter3 = null;
		OutputStreamWriter outputStreamWriter4 = null;
		try {
			outputStream1 = new FileOutputStream(file1);
			outputStream2 = new FileOutputStream(file2);
			outputStream3 = new FileOutputStream(file3);
			outputStream4 = new FileOutputStream(file4);
			outputStreamWriter1 = new OutputStreamWriter(outputStream1);
			outputStreamWriter2 = new OutputStreamWriter(outputStream2);
			outputStreamWriter3 = new OutputStreamWriter(outputStream3);
			outputStreamWriter4 = new OutputStreamWriter(outputStream4);
			for (Candidate candidate : listCandidate) {
				if (candidate instanceof Experience) {
					outputStreamWriter1.write(candidate.getCandidateID() + " ");
					outputStreamWriter1.write(candidate.getFullName() + " ");
					outputStreamWriter1.write(candidate.getBirthDay() + " ");
					outputStreamWriter1.write(candidate.getPhone() + " ");
					outputStreamWriter1.write(candidate.getEmail() + " ");
					outputStreamWriter1.write(candidate.getCandidate_type() + " ");
					outputStreamWriter1.write(((Experience)candidate).getExpInYear() + " ");
					outputStreamWriter1.write(((Experience)candidate).getProSkill() + " ");
					for (Certificated cer : candidate.getCertificatedDate()) {
						outputStreamWriter4.write(cer.getCertificatedID() + " ");
						outputStreamWriter4.write(cer.getCertificateName() + " ");
						outputStreamWriter4.write(cer.getCertificateRank() + " ");
						outputStreamWriter4.write(cer.getCertificatedDate() + " ");
						outputStreamWriter4.write(candidate.getCandidateID() + " ");
						outputStreamWriter4.write("\n");
					}
					outputStreamWriter1.write("\n");
				} else if (candidate instanceof Fresher) {
					outputStreamWriter2.write(candidate.getCandidateID() + " ");
					outputStreamWriter2.write(candidate.getFullName() + " ");
					outputStreamWriter2.write(candidate.getBirthDay() + " ");
					outputStreamWriter2.write(candidate.getPhone() + " ");
					outputStreamWriter2.write(candidate.getEmail() + " ");
					outputStreamWriter2.write(candidate.getCandidate_type() + " ");
					outputStreamWriter2.write(((Fresher)candidate).getGraduation_date() + " ");
					outputStreamWriter2.write(((Fresher)candidate).getGraduation_rank() + " ");
					outputStreamWriter2.write(((Fresher)candidate).getEducation() + " ");
					for (Certificated cer : candidate.getCertificatedDate()) {
						outputStreamWriter4.write(cer.getCertificatedID() + " ");
						outputStreamWriter4.write(cer.getCertificateName() + " ");
						outputStreamWriter4.write(cer.getCertificateRank() + " ");
						outputStreamWriter4.write(cer.getCertificatedDate() + " ");
						outputStreamWriter4.write(candidate.getCandidateID() + " ");
						outputStreamWriter4.write("\n");
					}
					outputStreamWriter2.write("\n");
				} else {
					outputStreamWriter3.write(candidate.getCandidateID() + " ");
					outputStreamWriter3.write(candidate.getFullName() + " ");
					outputStreamWriter3.write(candidate.getBirthDay() + " ");
					outputStreamWriter3.write(candidate.getPhone() + " ");
					outputStreamWriter3.write(candidate.getEmail() + " ");
					outputStreamWriter3.write(candidate.getCandidate_type() + " ");
					outputStreamWriter3.write(((Intern)candidate).getMajors() + " ");
					outputStreamWriter3.write(((Intern)candidate).getSemester() + " ");
					outputStreamWriter3.write(((Intern)candidate).getUniversity_name() + " ");
					for (Certificated cer : candidate.getCertificatedDate()) {
						outputStreamWriter4.write(cer.getCertificatedID() + " ");
						outputStreamWriter4.write(cer.getCertificateName() + " ");
						outputStreamWriter4.write(cer.getCertificateRank() + " ");
						outputStreamWriter4.write(cer.getCertificatedDate() + " ");
						outputStreamWriter4.write(candidate.getCandidateID() + " ");
						outputStreamWriter4.write("\n");
					}
					outputStreamWriter3.write("\n");
				}
				outputStreamWriter1.flush();
				outputStreamWriter2.flush();
				outputStreamWriter3.flush();
				outputStreamWriter4.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			outputStreamWriter1.close();
			outputStreamWriter2.close();
			outputStreamWriter3.close();
			outputStreamWriter4.close();
		}
		
	}

	private static void insertCandidateNonSQLQuery(Candidate candidate) {
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			cnn=JDBC.getConnections();
			cnn.setAutoCommit(false);
			String sql = "select * from Candidate";
			statement = cnn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = statement.executeQuery();
			rs.moveToInsertRow(); // Save con trỏ ở vị trí hiện tại và move con trỏ để insert 1 dòng nữa
			rs.updateString("CandidateID", candidate.getCandidateID());
			rs.updateString("FullName", candidate.getFullName());
			rs.updateString(3, candidate.getBirthDay());
			rs.updateString(4, candidate.getPhone());
			rs.updateString(5, candidate.getEmail());
			rs.updateInt(6, candidate.getCandidate_type());
			rs.updateString(9,((Fresher) candidate).getGraduation_date());
			rs.updateString(10,((Fresher) candidate).getGraduation_rank());
			rs.updateString(11,((Fresher) candidate).getEducation());
			rs.insertRow();
			for (Certificated cer : candidate.getCertificatedDate()) {
				insertCertifcateIntoDBNoSQL(cer,candidate.getCandidateID(),cnn);
			}
			rs.moveToCurrentRow(); // đưa con trỏ về lại vị trí đã lưu
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

	private static void insertCertifcateIntoDBNoSQL(Certificated cer, String CandidateID, Connection cnn) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		String sql = "select * from Certificated";
		try {
			statement = cnn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = statement.executeQuery();
			rs.moveToInsertRow();
			rs.updateString(1, cer.getCertificatedID());
			rs.updateString(2, cer.getCertificateName());
			rs.updateInt(3, cer.getCertificateRank());
			rs.updateString(4, cer.getCertificatedDate());
			rs.updateString(5, CandidateID);
			rs.insertRow();
			rs.moveToCurrentRow();
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
			insertCandidateNonSQLQuery(fr);
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

	private static void updateNonSQLQuery(Scanner sc) {
		Connection cnn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			cnn = JDBC.getConnections();
			System.out.println("Enter Candidate ID want to update");
			String id = sc.nextLine();
			System.out.println("Enter FullName want to change");
			String name = sc.nextLine();
			System.out.println("Enter Email want to update");
			String mail = sc.nextLine();
			String sql = "select * from Candidate";
			statement = cnn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getString("CandidateID").equals(id)) {
					rs.updateString("FullName", name);
					rs.updateString("Email", mail);
					rs.updateRow();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
//			cnn.setAutoCommit(false);
			String sql = "insert into Certificated values(?,?,?,?,?)";
			statement = cnn.prepareStatement(sql);
			statement.setString(1, cer.getCertificatedID());
			statement.setString(2, cer.getCertificateName());
			statement.setInt(3, cer.getCertificateRank());
			statement.setString(4, cer.getCertificatedDate());
			statement.setString(5, candidateID);
			statement.executeUpdate();
//			cnn.commit();
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
