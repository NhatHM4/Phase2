package Short_Assginment_301;

import java.util.Scanner;

public class exsercise_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sValue= sc.nextLine();
		String[] stringArray = {"FTP","Fresher", "Acedemy", "2018"};
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i].equals(sValue)) {
				System.out.println("Check "+ sValue +" in Array: Contained!");
			}
		}
	}
}
