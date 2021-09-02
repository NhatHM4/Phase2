package Long_Assginment_901;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) {
//        String line = "";
//        String name;
//        try {
//        	BufferedReader bff = new BufferedReader(new FileReader("D:\\nhat.txt"));
//			while ((line =  bff.readLine()) != null) {
//				System.out.println(line);
//				String[] cc = line.split(" ");
//				name = cc[0];
//			}
////        	line = "123 acs";
////        	String[]  a= line.split(" ");
////        	System.out.println(a[0]);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		
		System.out.println(isValidDate("9999-02-28"));
	}
	

    @SuppressWarnings("deprecation")
    public static boolean isValidDate(String date) {
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.setLenient(false);
            Date checkYear = dateFormat.parse(date);
            if (checkYear.getYear() >= 9999) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    



	
}
