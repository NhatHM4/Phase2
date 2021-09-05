package Codelean42;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai4 {
	public static boolean isNgto(int n) {
		int d = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				d++;
			}
		}

		if (d == 2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		List<Integer> listInt = new ArrayList<Integer>();
		int i = 1;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n != 1) {
			if (isNgto(i)) {
				if (n % i == 0) {
					n = n / i;
					listInt.add(i);
				} else {
					i++;
				}
			} else {
				i++;
			}
		}
		System.out.println(listInt.toString());
	}

}
