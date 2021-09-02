package Short_Assginment_602;

import java.util.ArrayList;
import java.util.Scanner;

public class ShapeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Rectangle> listRec = new ArrayList<Rectangle>();
		System.out.println("Enter number of Rectangle");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Rectangle rec = new Rectangle();
			System.out.println("Enter length of Rectangle" + i);
			int len = Integer.parseInt(sc.nextLine());
			System.out.println("Enter width of Rectangle" + i);
			int width = Integer.parseInt(sc.nextLine());
			rec.setLengthWidth(len, width);
			listRec.add(rec);
		}
		
		for (Rectangle rectangle : listRec) {
			rectangle.displayInfo();
			System.out.println();
		}
		int max = -1;
		int min = Integer.MAX_VALUE;
		for (Rectangle rectangle : listRec) {
				if (rectangle.calculateArea() >max) {
					max = rectangle.calculateArea();
				}
				if (rectangle.calculatePerimeter() < min ) {
					min = rectangle.calculatePerimeter();
				}
		}
		System.out.println(min + " " + max);
		System.out.println("Rectangle has the maxium area");
		for (Rectangle rectangle : listRec) {
			if (rectangle.calculateArea() == max) {
				rectangle.displayInfo();
			}
		}
		
		System.out.println("Rectangle has the minimun perimeter");
		for (Rectangle rectangle : listRec) {
			if (rectangle.calculatePerimeter() == min) {
				rectangle.displayInfo();
			}
		}
		
		
	}

}
