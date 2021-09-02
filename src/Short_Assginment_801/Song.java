package Short_Assginment_801;

import java.util.Scanner;

public class Song extends Multimedia {
	private String singer;
	
	public Song() {
		// TODO Auto-generated constructor stub
	}

	public Song(String name, double duration, String singer) {
		super(name, duration);
		this.singer = singer;
	}
	
	public void createSong() {
		Scanner sc = new Scanner(System.in);
		super.createMultimedia();
		System.out.println("Enter singer");
		this.singer  = sc.nextLine();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Song :             " + getName() + "           " + getDuration() + "         " + this.singer;
	}
	
}
