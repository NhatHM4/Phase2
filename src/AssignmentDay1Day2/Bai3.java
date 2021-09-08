package AssignmentDay1Day2;

public class Bai3 {
	public static int gt(int n) {
		if (n==1) {
			return 1;
		}else {
			return n*gt(n-1);
		}
	}
	public static void main(String[] args) {
//		System.out.println(gt(5));
		System.out.println(kq(3));
	}
	
	public static double kq(int n) {
		if (n==1) {
			return 1;
		} else {
			return (double) 1/gt(2*n-1) + kq(n-1);
		}
	}
}
