package AssignmentDay1Day2;

public class Bai6 {
	public static void convertBinary(int num){
        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    }
	
	public static void main(String[] args) {
		convertBinary(8);
	}
}
