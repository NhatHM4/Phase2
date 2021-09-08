package AssignmentDay1Day2;

public class Bai5 {
	public static int ucln(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return ucln(b, a%b);
		}
	}
	public static void main(String[] args) {
		System.out.println(ucln(12, 8));
	}
}
