package Short_Assginment_701;

public class Ford extends Car {
	public String name = "Ford";
	private int year;
	private int manufacturerDiscount;

	public Ford() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
		super(speed, regularPrice, color);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}

	
	
	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getManufacturerDiscount() {
		return manufacturerDiscount;
	}


	public void setManufacturerDiscount(int manufacturerDiscount) {
		this.manufacturerDiscount = manufacturerDiscount;
	}


	@Override
	public double getSalePrice() {
		super.setRegularPrice(getRegularPrice()*(1 - (double) manufacturerDiscount/100));
		return super.getRegularPrice();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
}
