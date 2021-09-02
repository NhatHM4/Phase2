package Long_Assginment_902;

import java.util.Scanner;

public class FixedWing extends Airplane {
	private String planType;
	private int minNRS;
	
	public FixedWing() {
		// TODO Auto-generated constructor stub
	}
	
	

	public FixedWing(String id, String model, int cruiseSpeed, int emptyWeight, int maxTakeOffWeight, String planType,
			int minNRS) {
		super(id, model, cruiseSpeed, emptyWeight, maxTakeOffWeight);
		this.planType = planType;
		this.minNRS = minNRS;
	}


	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID");
		super.setId(Validator.validateFW());
		super.input();
		System.out.println("Enter max takeoff weight");
		super.setMaxTakeOffWeight(Validator.validateNumber());
		System.out.println("Enter Type");
		this.planType = Validator.validateType();
		
	}
	@Override
	public void flyMethod() {
		System.out.println("Fixed Wing...");
	}



	public String getPlanType() {
		return planType;
	}



	public void setPlanType(String planType) {
		this.planType = planType;
	}



	public int getMinNRS() {
		return minNRS;
	}



	public void setMinNRS(int minNRS) {
		this.minNRS = minNRS;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fixed-Wing : "+ " plane " + this.planType + "min " + this.minNRS;
	}
	
}
