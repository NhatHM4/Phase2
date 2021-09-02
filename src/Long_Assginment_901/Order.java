package Long_Assginment_901;

public class Order {
	private String number;
	private String date;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String number, String date) {

		this.number = number;
		this.date = date;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{"+this.number + ";" + this.date + "}";
	}
	
	
}
