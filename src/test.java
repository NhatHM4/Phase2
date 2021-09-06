
public class test {
	static double fraction(int n) {
		if (n == 1)
			return 1;
		return (double) ((double)(1 / n) + (double)1/ fraction( n - 1)) ;
	}
	
	public static void main(String[] args) {
		System.out.println(fraction(5));
	}
}
