package Long_Assginment_1001.entities;

public class LineItem {
	private int orderId ;
	private int productId ;
	private int quantity;
	private double price;
	
	public LineItem() {
		// TODO Auto-generated constructor stub
	}

	public LineItem(int orderId, int productId, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
