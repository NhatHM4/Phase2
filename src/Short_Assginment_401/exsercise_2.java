package Short_Assginment_401;

public class exsercise_2 {
	public static Integer maximum(Integer[] myIntArray) {
		int max = myIntArray[0];
		for (int i = 0; i < myIntArray.length; i++) {
			if (max < myIntArray[i]) {
				max = myIntArray[i];
			}
		}
		return max;
	}
	
	public static Integer secondMaximum(Integer[] myIntArray) {
		int max = myIntArray[0];
		for (int i = 0; i < myIntArray.length; i++) {
			if (max < myIntArray[i]) {
				max = myIntArray[i];
			}
		}
		int max1 = myIntArray[0];
		for (int i = 0; i < myIntArray.length; i++) {
			if (max1 < myIntArray[i] && myIntArray[i] != max) {
				max1 = myIntArray[i];
			}
		}
		return max1;
	}
	public static void main(String[] args) {
		Integer[] myIntArray = { 43, 32, 53, 23, 12, 34, 3, 12, 43, 32 };
		System.out.println(maximum(myIntArray));
		System.out.println(secondMaximum(myIntArray));
	}
}
