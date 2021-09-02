package Short_Assginment_201;

import java.util.Scanner;

public class exsercise_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input first number: ");
		int firstNumber = sc.nextInt();
		System.out.println("Input second number:");
		int secondNumber = sc.nextInt();
		System.out.println("Input third number:");
		int thirdNumber = sc.nextInt();
		System.out.println("Input fourth number:");
		int fourNumber = sc.nextInt();

		if (!((firstNumber == secondNumber) && (firstNumber == thirdNumber) && (firstNumber == fourNumber))) {
			System.out.println("Numbers are not equal!");
		}
	}
}
