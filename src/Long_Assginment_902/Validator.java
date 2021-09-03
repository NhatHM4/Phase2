package Long_Assginment_902;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
	public static Scanner sc = new Scanner(System.in);

	public static String validateFW() {
		Pattern p = Pattern.compile("^FW[0-9]{5}$");
		String id = "";
		do {

			id = sc.nextLine();
			if (p.matcher(id).find()) {
				break;
			}
		} while (true);
		return id;
	}

	public static String validateRW() {
		Pattern p = Pattern.compile("^RW[0-9]{5}$");
		String id = "";
		do {

			id = sc.nextLine();
			if (p.matcher(id).find()) {
				break;
			}
		} while (true);
		return id;
	}

	public static String validateAP() {
		Pattern p = Pattern.compile("^AP[0-9]{5}$");
		String id = "";
		do {
			id = sc.nextLine();
			if (p.matcher(id).find()) {
				break;
			}
		} while (true);
		return id;
	}

	public static String validateModel() {
		Pattern p = Pattern.compile("^[a-zA-Z0-9]{1,40}$");
		String model = "";
		do {

			model = sc.nextLine();
			if (p.matcher(model).find()) {
				break;
			}
		} while (true);
		return model;
	}

	public static String validateType() {
		Pattern p = Pattern.compile("^(CAG|LGR|PRV)$");
		String type = "";
		do {
			System.out.println("Enter type");
			type = sc.nextLine();
			if (p.matcher(type).find()) {
				break;
			}
		} while (true);
		return type;
	}

	public static int validateNumberFW(int n) {
		int number = 0;
		do {

			number = Integer.parseInt(sc.nextLine());
		} while (number > n || number < 0);
		return number;
	}

	public static int validateMinRNS(int n) {
		int number = 0;
		do {

			number = Integer.parseInt(sc.nextLine());
		} while (number > n || number < 0);
		return number;
	};
	
	public static int validateTakeoffWeight(int n) {
		int number = 0;
		do {

			number = Integer.parseInt(sc.nextLine());
		} while (number >= 2*n || number < n);
		return number;
	}
	public static int validateNumber() {
		int number = 0;
		do {

			try {
			number = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				number = -1;
			}
		} while (number < 0);
		return number;
	}
	
	public static LocalDate validDate(Scanner sc) {
        String date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean isLoop = true;
        LocalDate checkDate = null;
        do {
            System.out.println("Input Date: ");
            date= sc.nextLine().trim();
            isLoop = true;
            try {
                checkDate = LocalDate.parse(date, formatter);
                return checkDate;   
            } catch (Exception e) {
                System.out.println("Date Is Not Valid!!!");
                isLoop = true;
            }
           
        } while (isLoop);
        return checkDate;
    }
	
	public static String validatePhone(Scanner sc) {
		Pattern p = Pattern.compile("^[0-9]{7,}$");
		String phone = "";
		do {
			System.out.println("Enter type");
			phone = sc.nextLine();
			if (p.matcher(phone).find()) {
				break;
			}
		} while (true);
		return phone;
	}
	
	public static String validateEmail(Scanner sc) {
		Pattern p = Pattern.compile("^[a-z][a-zA-Z0-9]+@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+$");
		String email = "";
		do {
			System.out.println("Enter type");
			email = sc.nextLine();
			if (p.matcher(email).find()) {
				break;
			}
		} while (true);
		return email;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LocalDate date = validDate(sc);
		System.out.println(date.getYear()+"");
		System.out.println(date.getMonthValue());
		System.out.println(date.getDayOfMonth());
//		String email = validatePhone(sc);
//		System.out.println(email);
	}
	
	public static LocalDate validLocalDate(String sc) {
        String date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean isLoop = true;
        LocalDate checkDate = null;
        do {
            System.out.println("Input Date: ");
            date= sc.trim();
            isLoop = true;
            try {
                checkDate = LocalDate.parse(date, formatter);
                return checkDate;   
            } catch (Exception e) {
                System.out.println("Date Is Not Valid!!!");
                isLoop = true;
            }
           
        } while (isLoop);
        return checkDate;
    }
}
