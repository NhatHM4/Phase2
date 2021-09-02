package Short_Assginment_801;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultimediaManagement {
	private static List<Multimedia> listOfMultimedia = new ArrayList<Multimedia>();

	public MultimediaManagement(List<Multimedia> listOfMultimedia) {
		this.listOfMultimedia = listOfMultimedia;
	}
	
	public static Multimedia addMultiMedia(Multimedia multimedia) {
		if(multimedia instanceof Video) {
			((Video) multimedia).createVideo();
			return multimedia;
		} else {
			((Song)multimedia).createSong();
			return multimedia;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("1.Add a new video");
		System.out.println("2.Add a new Song");
		System.out.println("3.Show all multimedia");
		System.out.println("4.Exit");
		int choose = Integer.parseInt(sc.nextLine());
		switch (choose) {
		case 1:
			Video v = new Video();
			listOfMultimedia.add(addMultiMedia(v));
			break;
		case 2:
			Song song = new Song();
			listOfMultimedia.add(addMultiMedia(song));
			break;
		case 3: 
			for (Multimedia multi : listOfMultimedia) {
				System.out.println(multi.toString());
			}

		default:
			break;
		}
		} while (true);
	}
	
}
