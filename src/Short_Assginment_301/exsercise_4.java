package Short_Assginment_301;

public class exsercise_4 {
	public static void main(String[] args) {
		int[] myIntArray = { 43, 32, 53, 23, 12, 34, 3, 12, 43, 32 };
		System.out.print("Original Array: ");
		for (int i = 0; i < myIntArray.length; i++) {
			System.out.print(myIntArray[i] + " ");
		}
		System.out.println();
		System.out.print("Reversed Array: ");
		for (int i = myIntArray.length - 1 ; i >= 0 ; i--) {
			System.out.print(myIntArray[i] + " ");
		}
	}
}
