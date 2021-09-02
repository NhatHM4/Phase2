package Short_Assginment_801;

import java.util.Scanner;

public abstract class Multimedia {
	private String name;
	private double duration;
	
	public Multimedia() {
		// TODO Auto-generated constructor stub
	}

	public Multimedia(String name, double duration) {
		this.name = name;
		this.duration = duration;
	}

	public void createMultimedia() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name Multimedia");
		this.name = sc.nextLine();
		System.out.println("Enter duration Multimedia");
		this.duration = Double.parseDouble(sc.nextLine());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	
	
}
