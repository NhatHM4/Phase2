package Short_Assginment_701;

public class Sedan extends Car {
	public String name = "Sedan";
	private int length;
	
	public Sedan() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Sedan(int speed, double regularPrice, String color, int length) {
		super(speed, regularPrice, color);
		this.length = length;
	}

	

	public int getLength() {
		return length;
	}

	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setLength(int length) {
		this.length = length;
	}


	@Override
	public double getSalePrice() {
		if (this.length>20 ) {
			super.setRegularPrice(0.95*super.getRegularPrice());
			return super.getRegularPrice();
		} else {
			super.setRegularPrice(0.9*super.getRegularPrice());
			return super.getRegularPrice();
		}
	}

}
