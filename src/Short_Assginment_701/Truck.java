package Short_Assginment_701;

public class Truck extends Car {
	public String name = "Truck";
	private int weight;

	public Truck(int speed, double regularPrice, String color, int weight) {
		super(speed, regularPrice, color);
		this.weight = weight;
	}

	public Truck() {

	}

	@Override
	public double getSalePrice() {
		if (this.weight > 2000) {
			super.setRegularPrice(super.getRegularPrice() * 0.9);
			return super.getRegularPrice();
		} else {
			super.setRegularPrice(super.getRegularPrice() * 0.8);
			return super.getRegularPrice();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
