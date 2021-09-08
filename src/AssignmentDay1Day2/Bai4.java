package AssignmentDay1Day2;

public class Bai4 {
	public static int tinhTongChuSo(int n) {
		int m = 0;
		int sum = 0;
		while(n != 0) {
			m = n % 10;
			n = n/10;
			sum = sum + m;
		}
		return sum;
	}
	
	public static int tinhTichChuSo(int n) {
		int m = 0;
		int sum = 1;
		while(n != 0) {
			m = n % 10;
			n = n/10;
			sum = sum*m;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(tinhTongChuSo(1234));
		System.out.println(tinhTichChuSo(12345));
	}
}
