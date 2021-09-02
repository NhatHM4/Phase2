package Short_Assginment_201;

import java.util.Scanner;

public class exsercise_3 {
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
		System.out.println("Input fiveth number:");
		int fiveNumber = sc.nextInt();
		System.out.println("The sum is " + (firstNumber + secondNumber + thirdNumber + fourNumber + fiveNumber)); 
		sc.close();
	}
}
