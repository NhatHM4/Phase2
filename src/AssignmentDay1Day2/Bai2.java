package AssignmentDay1Day2;

public class Bai2 {
	public static void main(String[] args) {
		System.out.println(dequy(3));
	}
	
	public static double dequy(int n) {
		if (n==1) {
			return 1;
		} else {
			return (double) 1/n + (double) dequy(n-1);
		}
	}
}
