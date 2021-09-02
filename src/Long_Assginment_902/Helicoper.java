package Long_Assginment_902;

import java.util.Scanner;

public class Helicoper extends Airplane {
	private String range;
	
	public Helicoper() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Helicoper(String id, String model, int cruiseSpeed, int emptyWeight, int maxTakeOffWeight, String range) {
		super(id, model, cruiseSpeed, emptyWeight, maxTakeOffWeight);
		this.range = range;
	}

	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID");
		super.setId(Validator.validateRW());
		super.input();
		System.out.println("Enter take off weight");
		super.setMaxTakeOffWeight(Validator.validateTakeoffWeight(super.getEmptyWeight()));
		System.out.println("Enter Range");
		this.range = sc.nextLine();
		
	}

	
	@Override
	public void flyMethod() {
		System.out.println("Rotated Wing...");
	}


	public String getRange() {
		return range;
	}


	public void setRange(String range) {
		this.range = range;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Helicoper : " +  " range " + this.range;
	}
	
}
