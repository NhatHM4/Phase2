package Short_Assginment_301;

import java.util.Scanner;

public class exsercise_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] intArray = new int[len];
		int j =0;
		String c = "";
		do {
			intArray[j] = sc.nextInt();
			sc.nextLine();
			j = j+1;
			System.out.println("Do you want to continue? (Y/N)");
			c = sc.nextLine();
		} while (j < len && c.equalsIgnoreCase("Y"));
		System.out.println("Enter number of Array");
		int value = sc.nextInt();
		int count = 0;
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i]==value) {
				count++;
			}
		}
		System.out.println("Amount of frequence: " + count);
		System.out.print("Indexs ");
		for (int i = 0; i < intArray.length; i++) {
			if (intArray[i]==value) {
				System.out.print(i + " ");
			}
		}
	}
}
