package Codelean42;

public class test {
	public static void main(String[] args) {
		String a = "abc";
		String b = "abc";
		String a1 = new String("abc");
		String a2= new String("abc");
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		System.out.println(System.identityHashCode(a1));
		System.out.println(System.identityHashCode(a2));
		
		
		
	}
}
