package AssignmentDay1Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import exception.PhoneNumberFormatException;
import exception.Validator;

public class Student {
	private String stdNo;
	private String stdName;
	private String stdPhone;
	private String StdEmail;
	private String gradePoint;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String stdNo, String stdName, String stdPhone, String stdEmail, String gradePoint) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.stdPhone = stdPhone;
		StdEmail = stdEmail;
		this.gradePoint = gradePoint;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}

	public String getStdEmail() {
		return StdEmail;
	}

	public void setStdEmail(String stdEmail) {
		StdEmail = stdEmail;
	}

	public String getGradePoint() {
		return gradePoint;
	}

	public void setGradePoint(String gradePoint) {
		this.gradePoint = gradePoint;
	}

	public static void saveToFile(Student std) throws IOException {
		File file1 = new File("E:\\hoc lap trinh\\data\\Student.txt");
		OutputStream outputStream1 = null;
		OutputStreamWriter outputStreamWriter1 = null;
		outputStream1 = new FileOutputStream(file1);
		outputStreamWriter1 = new OutputStreamWriter(outputStream1);
		outputStreamWriter1.write(std.getStdNo() + ",");
		outputStreamWriter1.write(std.getStdName() + ",");
		outputStreamWriter1.write(std.getStdPhone() + ",");
		outputStreamWriter1.write(std.getStdEmail() + ",");
		outputStreamWriter1.write(std.getGradePoint() + ",");
		outputStreamWriter1.write("\n");
		outputStreamWriter1.flush();
		outputStreamWriter1.close();
	}

	public static List<StringBuilder> findAll() throws IOException, PhoneNumberFormatException {
		String line1 = "";
		
		List<StringBuilder> loi = new ArrayList<StringBuilder>();
		int i =0;
		BufferedReader bff1 = new BufferedReader(new FileReader("E:\\hoc lap trinh\\data\\Student.txt"));
		while ((line1 = bff1.readLine()) != null) {
			i++;
			StringBuilder sub = new StringBuilder("");
			String[] data = line1.split(",");
//			System.out.print(data[0] + ",");
//			System.out.print(data[1] + ",");
			if (!Validator.validatePhoneNumber(data[2])) {
				sub.append("Line " + i+ " co loi sai dinh dang phone");
//				throw new PhoneNumberFormatException("May nhap sai dinh dang");
			} else {
//				System.out.print(data[2] + ",");
			}
			if (!Validator.validateEmail(data[3])) {
				if (sub.toString().equals("")) {
					sub.append("Line " + i+ " co loi sai dinh dang email");
				} else {
					sub.append(", Email");
				}
				
			} else {
//				System.out.print(data[3] + ",");
			}
//			System.out.print(data[4] + ",");
			loi.add(sub);
		}
		bff1.close();
		return loi;
	}
	public static void main(String[] args) throws IOException, PhoneNumberFormatException {
//		try {
//			saveToFile(new Student("001", "Nhat", "+919367788755", "ahihi", "10"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			findAll();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (PhoneNumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		List<StringBuilder> loi = findAll();
		for (StringBuilder stringBuilder : loi) {
			System.out.println(stringBuilder);
		}
		
	}
}
