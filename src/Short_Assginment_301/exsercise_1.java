package Short_Assginment_301;

import java.util.Scanner;

public class exsercise_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = 0;
		for (int i = 1; i <= 100; i++) {
			s = s+i;
		}
		System.out.println("Average of all " + n +" first numbers: " + s/n);
	}
}
