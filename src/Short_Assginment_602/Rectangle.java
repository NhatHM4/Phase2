package Short_Assginment_602;

public class Rectangle implements Shape {
	private int length;
	private int width;
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	@Override
	public int calculatePerimeter() {
		
		return 2*(this.length + this.width);
	}

	@Override
	public int calculateArea() {
		// TODO Auto-generated method stub
		return this.length*this.width;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return this.length;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	@Override
	public void setLengthWidth(int len, int width) {
		this.length = len;
		this.width = width;

	}
	
	public void displayInfo() {
		System.out.println("Len : " + this.length);
		System.out.println("Width : " + this.width);
		System.out.println("perimeter " + calculatePerimeter());
		System.out.println("area : " + calculateArea());
	}

}
