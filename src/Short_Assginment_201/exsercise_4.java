package Short_Assginment_201;

import java.util.Scanner;

public class exsercise_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double radius = sc.nextDouble();
		double height = sc.nextDouble();
		double sufaceArea = 0d ;
		double baseArea = 0d;
		double volume = 0d;
		
		sufaceArea = (2*Math.PI*radius) * height;
		baseArea = (Math.PI*radius*radius);
		volume = baseArea*height;
		System.out.println("Surface area = " + sufaceArea);
		System.out.println("Base area = " + baseArea);
		System.out.println("Volume = " + volume);
	}
}
