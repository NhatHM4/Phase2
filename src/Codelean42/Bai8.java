package Codelean42;

import java.util.Arrays;
import java.util.Scanner;

public class Bai8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = count(n);
		int[] a = new int[m];
		int[] a1 = new int[m];
		int i = 0;
		while (n != 0) {
			a[i] = n % 10;
			a1[m - i - 1] = n % 10;
			n = n / 10;
			i++;
		}
		System.out.println(equalsArray(a, a1));
	}

	public static boolean equalsArray(int[] a, int[] a1) {
		for (int i = 0; i < a1.length; i++) {
			if (a[i]!=a1[i])
				return false;
		}
		return true;
	}
	
	public static int count(int n) {
		int m = 0;
		int sum = 0;
		while (n != 0) {
			m = n % 10;
			n = n / 10;
			sum++;
		}
		return sum;
	}

}
